package com.cinemaapp.backend.tools;

import com.cinemaapp.backend.entitys.Movie;
import com.cinemaapp.backend.entitys.Seat;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;


@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String buildNewMovie(Movie movie) {
        Context context = new Context();
        context.setVariable("title", movie.getTitle());
        context.setVariable("sinceDate", "Film będzie dostępny od " + new LocalDate(movie.getSinceDate()).toString() + ".");
        return templateEngine.process("newMovie", context);
    }

    public String buildConfirmationCode(Seat seat, List<String> reservation, String confirmation, String town) {
        Context context = new Context();
        context.setVariable("movie", "Tytuł filmu: " + seat.getShow().getMovie().getTitle());
        context.setVariable("showDate", "Data i godzina rozpoczęcia seansu: " + seat.getShow().getDate().toString().substring(0,seat.getShow().getDate().toString().length()-2));
        context.setVariable("showProjection", "Rodzaj projekcji: " + seat.getShow().getProjection());
        context.setVariable("showVersion", "Wersja przekazu: " + seat.getShow().getVersion());
        context.setVariable("room", "Numer sali: " + seat.getShow().getRoom().getRoomNumber());
        context.setVariable("reservation", reservation);
        context.setVariable("confirmation", "Twój kod potwiedzający: " + confirmation);
        context.setVariable("town", "\nDziękujemy za skorzystanie z usług kina w miejscowości " + town);
        return templateEngine.process("confCode", context);
    }

}
