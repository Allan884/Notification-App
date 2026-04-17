package allan_saariste.dynamic_notification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import allan_saariste.dynamic_notification.entity.Notification;
import allan_saariste.dynamic_notification.repository.NotificationRepository;
import jakarta.transaction.Transactional;

@Service
public class NotificationService {


    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Notification getById(Long id) {
        return notificationRepository.findById(id).orElseThrow();
    }


    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

    @Transactional
    public void activate(Long id) {
        notificationRepository.deactivateAll();

        Notification n = notificationRepository.findById(id)
            .orElseThrow();
            
        n.setActive(true);
        notificationRepository.save(n);
        
    }


    public Notification getActiveNotification() {
        return notificationRepository.findByActiveTrue().orElse(null);
    }
    
}
