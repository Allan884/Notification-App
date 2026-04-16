package allan_saariste.DynamicNotificationModule.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import allan_saariste.DynamicNotificationModule.Entity.Notification;
import allan_saariste.DynamicNotificationModule.Service.NotificationService;

@RestController
public class NotificationController {
    private NotificationService noteService;

    @GetMapping("/notification")
    public Map<String, Object> getNotification() {

        Notification note = noteService.getActiveNotification();

        if (note != null) {
            return Map.of(
                "title", note.getTitle(),
                "content", note.getContent()
                
            );
        }

        return Map.of(
            "status", "OK",
            "message", "System is running normally"
        );
    }

}