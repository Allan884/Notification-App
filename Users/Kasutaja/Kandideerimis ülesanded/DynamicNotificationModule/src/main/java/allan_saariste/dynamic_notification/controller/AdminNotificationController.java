package allan_saariste.dynamic_notification.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allan_saariste.dynamic_notification.entity.Notification;
import allan_saariste.dynamic_notification.service.NotificationService;

@RestController
@RequestMapping("/api/admin/notification")
public class AdminNotificationController {

    private final NotificationService service;

    public AdminNotificationController(NotificationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notification> getAll() {
        return service.getAll();
    }

     @PostMapping
    public Notification create(@RequestBody Notification n) {
        return service.save(n);
    }

    @PutMapping("/{id}")
    public Notification update(@PathVariable Long id, @RequestBody Notification notification) {
        return service.update(id, notification);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/{id}/activate")
    public void activate(@PathVariable Long id) {
        service.setActive(id);
    }

    @PostMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
    service.deactivate(id);
}

    
}
