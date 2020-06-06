package deckpackage;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author Ethan Johnson
 * Loosely based off of this page: https://www.geeksforgeeks.org/send-email-using-java-program/
 */
public class MailMan {

    private String server;
    private String sender;
    private Session session;

    /*
     * Note: This constructor doesn't take credentials since some SMTP servers don't require them.
     */
    public MailMan(String server, String sender) {
        this(server, sender, null, null);
    }

    public MailMan(String server, String sender, String user, String pass) {
        this.server = server;
        this.sender = sender;

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", server);
        if(user != null && pass != null) {
            session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, pass);
                }
            });
        } else {
            session = Session.getDefaultInstance(properties);
        }
    }

    public void sendMessage(String recipient, String subject, String contents) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(contents);

            Transport.send(message);
            System.out.println("Mail sent successfully");
        } catch (Exception e) {
            System.err.println("Unable to send message");
        }
    }

    public String getServer() {
        return server;
    }

    public String getSender() {
        return sender;
    }
}
