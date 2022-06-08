package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class NotificationTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chat_id;
    private String notification;
    private LocalDateTime sign_up_date;
    private LocalDateTime received_date;

    public NotificationTask() {
    }

    public NotificationTask(Long chat_id, String notification, LocalDateTime sign_up_date) {
        this.chat_id = chat_id;
        this.notification = notification;
        this.sign_up_date = sign_up_date;
    }

    public NotificationTask(Long chat_id, String notification, LocalDateTime sign_up_date, LocalDateTime received_date) {
        this.chat_id = chat_id;
        this.notification = notification;
        this.sign_up_date = sign_up_date;
        this.received_date = received_date;
    }

    public LocalDateTime getReceived_date() {
        return received_date;
    }

    public void setReceived_date(LocalDateTime received_date) {
        this.received_date = received_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public LocalDateTime getSign_up_date() {
        return sign_up_date;
    }

    public void setSign_up_date(LocalDateTime sign_up_date) {
        this.sign_up_date = sign_up_date;
    }
}
