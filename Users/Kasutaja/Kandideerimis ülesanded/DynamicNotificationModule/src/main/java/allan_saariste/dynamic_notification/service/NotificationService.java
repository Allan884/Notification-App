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
        if (notification.getTitle() == null
            || notification.getTitle().isBlank()
            || notification.getContent() == null
            || notification.getContent().isBlank()) {
                throw new RuntimeException("Title and content is required");
            }

        return notificationRepository.save(notification);
    }
    
    public Notification update(Long id, Notification updated) {

        if (updated.getTitle() == null
            || updated.getTitle().isBlank()
            || updated.getContent() == null
            || updated.getContent().isBlank()) {
                throw new RuntimeException("Title and content is required");
            }

        Notification existing = notificationRepository.findById(id).orElseThrow();

        existing.setTitle(updated.getTitle());
        existing.setContent(updated.getContent());

        return notificationRepository.save(existing);

    }

    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

    @Transactional
    public void setActive(Long id) {
    notificationRepository.deactivateAll();

    Notification selected = notificationRepository.findById(id).orElseThrow();
    selected.setActive(true);

    notificationRepository.save(selected);
}

    @Transactional
    public void deactivate(Long id) {
    Notification n = notificationRepository.findById(id).orElseThrow();
    n.setActive(false);
    notificationRepository.save(n);
}


    public Notification getActiveNotification() {
        return notificationRepository.findByActiveTrue().orElse(null);
    }
    
}
