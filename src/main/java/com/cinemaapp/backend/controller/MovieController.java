package com.cinemaapp.backend.controller;

import com.cinemaapp.backend.entitys.Movie;
import com.cinemaapp.backend.entitys.User;
import com.cinemaapp.backend.service.EmailService;
import com.cinemaapp.backend.service.MovieService;
import com.cinemaapp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;
    private final EmailService emailService;
    private final UserService userService;

    @Autowired
    public MovieController(MovieService movieService, EmailService emailService, UserService userService) {
        this.movieService = movieService;
        this.emailService = emailService;
        this.userService = userService;
    }

    @RequestMapping(value = "/addOrUpdateMovie", method = RequestMethod.POST)
    public void addOrUpdateMovie(@RequestBody Movie movieEntity) {
        Integer movieId = movieEntity.getId();
        movieService.addMovie(movieEntity);
        if (movieId == null) {
            List<User> usersList = userService.getUserToSendEmail();
            for (User user : usersList) {
                emailService.sendNewMovieMessage(user.getEmail(), "Nowy film w KINO INŻYNIER - " + movieEntity.getTitle(), movieEntity);
            }
        }
    }

    @RequestMapping(value = "/user/getMovie", method = RequestMethod.GET)
    public ResponseEntity<Map> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", movieService.getAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getMovieTopThree", method = RequestMethod.GET)
    public ResponseEntity<Map> getMovieTopThree(Integer cinemaId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", movieService.getMovieTopThree(cinemaId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getMovieForWeek", method = RequestMethod.GET)
    public ResponseEntity<Map> getMovieForWeek(Integer cinemaId) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", movieService.getMovieForWeek(cinemaId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/getMovieByDate", method = RequestMethod.GET)
    public ResponseEntity<Map> getMovieByDate() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", movieService.getMovieByDate());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteMovie", method = RequestMethod.DELETE)
    public void deleteMovie(@RequestBody Integer value) {
        movieService.deleteMovie(value);
    }


    @RequestMapping(value = "/user/getMovie/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional> getById(@PathVariable("id") Integer id) {
        Optional<Movie> movie = movieService.getById(id);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
