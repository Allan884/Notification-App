package allan_saariste.dynamic_notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Boolean active = false;

    public Notification() {}

    
    public Notification(String title, String content, Boolean active) {
        this.title = title;
        this.content = content;
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
    return id;
    }

    public void setId(Long id) {
    this.id = id;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }



    
}
