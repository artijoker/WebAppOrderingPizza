package com.example.webapporderingpizza;

import java.io.*;
import java.util.*;
import javax.mail.*;

import javax.mail.internet.*;

public class ServiceEmail {

    public static void sendEmail(String address,
                                 String topic,
                                 String text)
            throws AddressException, MessagingException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.mail.ru");
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "ArTi_j0Ker",
                        "jD6pgpgrk1a1vZdDaaBq");
            }
        };

        Session session = Session.getInstance(properties, auth);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("arti_j0ker@mail.ru"));
        InternetAddress[] addresses = {new InternetAddress(address)};

        message.setRecipients(Message.RecipientType.TO, addresses);
        message.setSubject(topic);
        message.setSentDate(new Date());
        message.setText(text);
        Transport.send(message);

    }
}
