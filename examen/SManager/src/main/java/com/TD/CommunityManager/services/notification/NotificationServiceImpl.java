/*package com.TD.CommunityManager.services.notification;

import com.TD.CommunityManager.model.NotificationEmail;
import com.TD.CommunityManager.services.user.UserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final AmqpTemplate rabbitTemplate;
    private final JavaMailSender javaMailSender;
    private final UserService userService;

    @Value("${yourapp.rabbitmq.exchange}")
    private String exchange;

    @Value("${yourapp.rabbitmq.routingkey}")
    private String routingKey;

    @Autowired
    public NotificationServiceImpl(AmqpTemplate rabbitTemplate, JavaMailSender javaMailSender, UserService userService) {
        this.rabbitTemplate = rabbitTemplate;
        this.javaMailSender = javaMailSender;
        this.userService = userService;
    }

    @Override
    public void envoyerNotificationDeDemande(Long userId, String message) {
        sendEmailNotification(userId, message);
    }

    @Override
    public void envoyerNotificationDIncident(Long userId, String message) {
        sendEmailNotification(userId, message);
    }

    @Override
    public void envoyerNotificationPourAgents(String message) {
        NotificationEmail notificationEmail = new NotificationEmail("agents@example.com", "Notification pour Agents", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, notificationEmail);
    }

    private void sendEmailNotification(Long userId, String message) {
        String emailDestinataire = userService.getEmailByUserId(userId);
        if (emailDestinataire == null || emailDestinataire.isEmpty()) {
            throw new IllegalArgumentException("Aucun email trouvé pour l'utilisateur avec l'ID: " + userId);
        }
        NotificationEmail notificationEmail = new NotificationEmail(emailDestinataire, "Notification", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, notificationEmail);
    }
}
*/