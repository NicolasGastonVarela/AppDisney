package com.AppDisney.AppDisney.Email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    SendGrid sendGrid;

    public Response sendemail(EmailRequest emailRequest) {

        Mail mail = new Mail(new Email("nicolasgastonvarela@gmail.com"), emailRequest.getSubject(), new Email(emailRequest.getTo()), new Content("text/plain", emailRequest.getBody()));
        mail.setReplyTo(new Email("nicolasgastonvarela@gmail.com"));
        Request request = new Request();

        Response response = null;

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("/auth/login");
            request.setBody(mail.build());
            response=this.sendGrid.api(request);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return response;

    }
}