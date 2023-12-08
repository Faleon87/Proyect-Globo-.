package services;

import javax.mail.MessagingException;

public interface IMailService {
    void sendMail(String from,String to,String subject, String msg) throws MessagingException;
}
