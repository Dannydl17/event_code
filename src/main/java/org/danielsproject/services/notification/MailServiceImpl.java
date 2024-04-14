package org.danielsproject.services.notification;



import lombok.AllArgsConstructor;
import org.danielsproject.dtos.response.NotificationResponse;
import org.danielsproject.utils.MailUtil;
import org.danielsproject.utils.TemplateLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService{


    @Override
    public NotificationResponse sendRegistrationSuccessfulMail(String email, String templatePath, String subject) {
        Resource resource = new ClassPathResource(templatePath);
        String htmlContent = TemplateLoader.load(resource);
        String message = MailUtil.send(email, htmlContent, subject);
        return NotificationResponse.builder().message(message).build();
    }
}
