package id.hikari.security.training.hikarisecurity.endpoint.impl;

import id.hikari.security.training.hikarisecurity.data.dto.response.ResponseEmailDTO;
import id.hikari.security.training.hikarisecurity.email.EmailCfg;
import id.hikari.security.training.hikarisecurity.email.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/feedback")
public class FeedbackEndPoint {
    private EmailCfg emailCfg;

    public FeedbackEndPoint(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }

    @PostMapping
    public ResponseEntity sendFeedback(@RequestBody Feedback feedback,
                                       BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback is not valid");
        }

        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(feedback.getEmail());
        mailMessage.setTo("ikhsanhikari29@gmail.com");
        mailMessage.setSubject("New feedback from " + feedback.getName());
        mailMessage.setText(feedback.getFeedback());

        // Send mail
        mailSender.send(mailMessage);

        return ResponseEntity.ok(new ResponseEmailDTO("Your Feedback Successfully send"));
    }
}
