package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Cinema;
import com.cinemaapp.backend.entitys.Reservation;
import com.cinemaapp.backend.entitys.Seat;
import com.cinemaapp.backend.service.EmailService;
import com.cinemaapp.backend.service.ReservationService;
import com.cinemaapp.backend.service.SeatService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RestController()
@RequestMapping("/api")
public class ReservationController {

    private final ReservationService reservationService;

    private final SeatService seatService;

    private final EmailService emailService;

    @Async
    void executeTaskT(List<Integer> seats, List<Reservation> reservations, Long dateMs) {
        Runnable exampleRunnable = () -> {
            List<Seat> listSeat = seatService.getSeatsById(seats);
            if (listSeat.get(0).getPrice() == null) {
                for (Seat seat : listSeat) {
                    seat.setStatus("wolne");
                }
                seatService.addListOfSeat(listSeat);
                reservationService.deleteReservationList(reservations);
            }
        };

        ScheduledExecutorService localExecutor = Executors.newSingleThreadScheduledExecutor();
        TaskScheduler scheduler = new ConcurrentTaskScheduler(localExecutor);

        scheduler.schedule(exampleRunnable,
                new Date(dateMs - 1200000L));
    }

    @Autowired
    public ReservationController(ReservationService reservationService, SeatService seatService, EmailService emailService) {
        this.reservationService = reservationService;
        this.seatService = seatService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/user/addFewReservations", method = RequestMethod.POST)
    public ResponseEntity<String> addOrUpdateReservation(@RequestBody List<Reservation> reservationEntity, String emailValue) {
        Map<String, Object> map = new HashMap<>();
        List<String> seatList = new ArrayList<>();
        for (Reservation res : reservationEntity) {
            if (res.getSeat().getStatus().equals("Zarezerwowane")) {
                return new ResponseEntity<>("Miejsce zostało już przez kogoś zarezerwowane. Proszę wybrać inne", HttpStatus.CONFLICT);
            }
        }
        String code = RandomString.make(10);
        List<Integer> ids = new ArrayList<>();
        for (Reservation reservation : reservationEntity) {
            reservation.setConfirmatoryCode(code);
            ids.add(reservation.getSeat().getId());
        }
        reservationService.addFewReservation(reservationEntity);
        List<Seat> seatsById = seatService.getSeatsById(ids);
        for (Seat seat : seatsById) {
            seat.setStatus("Zarezerwowane");
            seatList.add("Rząd: " + seat.getArmchair().getRow() + ", miejsce:" + seat.getArmchair().getSeat_number());
        }
        seatService.addListOfSeat(seatsById);
        Cinema cinema = seatsById.get(0).getArmchair().getRoom().getCinema();
        if (emailValue != null && emailValue.length() > 2) {
            emailService.sendConfCodeMessage(seatsById.get(0),
                    emailValue,
                    "KINO INŻYNIER - " + cinema.getTown() + " - kod potwierdzający",
                    seatList,
                    code,
                    cinema.getTown());
            executeTaskT(ids, reservationEntity, seatsById.get(0).getShow().getDate().getTime());
            return new ResponseEntity<>("Rezerwacji dokonano pomyślnie.", HttpStatus.OK);
        } else {
            executeTaskT(ids, reservationEntity, seatsById.get(0).getShow().getDate().getTime());
            return new ResponseEntity<>(code, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee/getReservationByCode", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllByCode(String confirmatoryCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", reservationService.getByConfirmatoryCode(confirmatoryCode));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/loggedUser/getReservationByUser", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllByUser(String login) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", reservationService.getAllByUserLogin(login));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/getReservation", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", reservationService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/loggedEmployee/deleteReservationList", method = RequestMethod.DELETE)
    public void deleteReservationList(@RequestBody List<Reservation> reservations) {
        reservationService.deleteReservationList(reservations);
    }

    @RequestMapping(value = "/deleteReservation", method = RequestMethod.DELETE)
    public void deleteReservation(@RequestBody Integer value) {
        reservationService.deleteReservation(value);
    }


}
