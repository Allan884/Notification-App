package allan_saariste.dynamic_notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import allan_saariste.dynamic_notification.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>  {
    
}
