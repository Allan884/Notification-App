package allan_saariste.dynamic_notification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import allan_saariste.dynamic_notification.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>  {

    @Modifying
    @Query("UPDATE Notification n SET n.active = false")
    void deactivateAll();

    Optional<Notification> findByActiveTrue();
    
}
