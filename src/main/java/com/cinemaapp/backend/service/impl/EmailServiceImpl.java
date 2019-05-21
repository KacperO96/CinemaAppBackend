package com.cinemaapp.backend.service.impl;

import com.cinemaapp.backend.entitys.Movie;
import com.cinemaapp.backend.entitys.Seat;
import com.cinemaapp.backend.service.EmailService;
import com.cinemaapp.backend.tools.MailContentBuilder;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    private final MailContentBuilder mailContentBuilder;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender, MailContentBuilder mailContentBuilder) {
        this.emailSender = emailSender;
        this.mailContentBuilder = mailContentBuilder;
    }

    @Override
    public void sendNewMovieMessage(String to, String subject, Movie movie) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            String content = mailContentBuilder.buildNewMovie(movie);
            messageHelper.setText(content, true);
            URL url = new URL(movie.getUrlImageLink());
            InputStream stream = url.openStream();
            messageHelper.addInline("imageResourceName", new ByteArrayResource(IOUtils.toByteArray(stream)), "image/jpg");
            messageHelper.addInline("logo", new ClassPathResource("static/logo-secondary-text-bottom.svg.png"));
        };
        try {
            emailSender.send(messagePreparator);

        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendConfCodeMessage(Seat seat, String to, String subject, List<String> reservation, String confCode, String town) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            String content = mailContentBuilder.buildConfirmationCode(seat, reservation, confCode, town);
            messageHelper.setText(content, true);
            messageHelper.addInline("logo", new ClassPathResource("static/logo-secondary-text-bottom.svg.png"));
        };
        try {
            emailSender.send(messagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
