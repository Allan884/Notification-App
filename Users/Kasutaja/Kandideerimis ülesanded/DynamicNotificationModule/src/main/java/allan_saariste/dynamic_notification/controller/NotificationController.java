package allan_saariste.dynamic_notification.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allan_saariste.dynamic_notification.entity.Notification;
import allan_saariste.dynamic_notification.service.NotificationService;


@RestController
@RequestMapping("/api")
public class NotificationController {

    private NotificationService noteService;


    public NotificationController(NotificationService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notification")
    public Map<String, Object> getNotification() {

        Notification note = noteService.getActiveNotification();

        if (note != null) {
            return Map.of(
                "title", note.getTitle(),
                "content", note.getContent(),
                "status", "NOTIFICATION",
                "timestamp", LocalDateTime.now(),
                "support", "support@tehik.ee"
            
            );
        }

        return Map.of(
            "status", "OK",
            "message", "System is running normally",
            "timestamp", LocalDateTime.now(),
            "support", "support@tehik.ee"
        );
    }

}