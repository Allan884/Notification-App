package allan_saariste.DynamicNotificationModule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import allan_saariste.DynamicNotificationModule.Entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>  {
    
}
