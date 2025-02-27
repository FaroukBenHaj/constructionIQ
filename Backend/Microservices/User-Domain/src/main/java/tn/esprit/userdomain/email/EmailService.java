package tn.esprit.userdomain.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import org.thymeleaf.context.Context;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private final JavaMailSender mailSender;
    @Autowired
    private final SpringTemplateEngine templateEngine;

    public EmailService(JavaMailSender mailSender, SpringTemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Async
    public void sendEmail(String to,
                          String subject,
                          String username ,
                          String emailTemplate ,
                          String activationCode ,
                          String confirmationUrl  ) throws MessagingException {
       String templateName;
       if(activationCode == null) {
           templateName = "Confirm-email";
       }else {
           templateName = EmailTemplate.ACTIVATION_ACCOUNT.name();
       }
       MimeMessage message = mailSender.createMimeMessage();
       MimeMessageHelper messageHelper = new MimeMessageHelper(
               message,
               MimeMessageHelper.MULTIPART_MODE_MIXED,
               StandardCharsets.UTF_8.name()
       );

       Map<String , Object> model = new HashMap<>();
       model.put("Username", username);
       model.put("ConfirmationURL", confirmationUrl);
       model.put("ActivationCode", activationCode);

        Context context = new Context();
        context.setVariables(model);
        messageHelper.setFrom("belhajfarouk03@gmail.com");
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);

        String html = templateEngine.process(templateName, context);

        messageHelper.setText(templateName, true);
        mailSender.send(message);

    }
}
