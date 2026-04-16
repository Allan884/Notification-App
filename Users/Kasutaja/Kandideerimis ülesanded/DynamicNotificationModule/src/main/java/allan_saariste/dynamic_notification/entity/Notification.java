package allan_saariste.dynamic_notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private boolean isActive = false;

    public Notification() {}

    
    public Notification(String title, String content, boolean isActive) {
        this.title = title;
        this.content = content;
        this.isActive = isActive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    } 

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    } 

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }



    
}
