package edu.neu.csye6200.controller.Util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    private final static String username = "example@gmail.com";
    private final static String password = "password";

    private final Session session;
    private static final MailUtil instance = new MailUtil();

    private MailUtil() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // enable debug
        session.setDebug(false);
    }

    public static MailUtil getInstance() {
        return instance;
    }

    private void sendMail(String to, String subject, String content) {
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject, "UTF-8");
            message.setText(content, "UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MailUtil mailUtil = MailUtil.getInstance();
        String toWhom = "example@qq.com";
        String subject = "vaccine reminder";
        String content = "vaccine a not get";
        mailUtil.sendMail(toWhom, subject, content);
    }
}
