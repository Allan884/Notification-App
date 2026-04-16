package allan_saariste.DynamicNotificationModule.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import allan_saariste.DynamicNotificationModule.Entity.Notification;
import allan_saariste.DynamicNotificationModule.Repository.NotificationRepository;

public class NotificationService {


    @Autowired
    private NotificationRepository notificationRepository;

    public Notification getNotification() {

        List<Notification> notifications = notificationRepository.findAll();

        for (Notification n : notifications) {
            if (n.isActive()) {
                return n;
            } 
        }
        return null;
    }
    
}
