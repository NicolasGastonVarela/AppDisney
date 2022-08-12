package com.AppDisney.AppDisney.Email;

import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendemail(@RequestBody EmailRequest emailRequest){

        Response response=emailService.sendemail(emailRequest);
        if(response.getStatusCode()==200 || response.getStatusCode()==202)
        return new ResponseEntity<>("Envio exitoso", HttpStatus.OK);
        return new ResponseEntity<>("Error en el envio", HttpStatus.NOT_FOUND);
    }
}
