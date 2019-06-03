/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author santi
 */
public class GestorMail {

    public static void enviarMail(String email, Usuario u) throws MessagingException {
        final String username = "ruletasfbot.recordatorio@gmail.com";
        final String password = "ruletaSF123";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("ruletasfbot.recordatorio@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(email)
        );
        message.setSubject("Recordatorio de Contraseña");
        message.setText("Estimado " + u.getNombre() + ","
                + "\nSe ha solicitado un recordatorio de la contraseña."
                + "\n\nContraseña: " + u.getPassword()
                + "\n\nLe deseamos mucha suerte en su juego."
                + "\nNuestro más cordial saludo,"
                + "\n\nEl equipo técnico de Ruleta SF.");

        Transport.send(message);
    }

}
