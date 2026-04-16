package allan_saariste.dynamic_notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import allan_saariste.dynamic_notification.entity.Notification;
import allan_saariste.dynamic_notification.repository.NotificationRepository;

@Service
public class NotificationService {


    @Autowired
    private NotificationRepository notificationRepository;

    public Notification getActiveNotification() {

        List<Notification> notifications = notificationRepository.findAll();

        for (Notification n : notifications) {
            if (n.isActive()) {
                return n;
            } 
        }
        return null;
    }
    
}
