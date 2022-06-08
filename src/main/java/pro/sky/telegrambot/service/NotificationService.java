package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.model.Message;
import pro.sky.telegrambot.model.NotificationTask;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationService {

    NotificationTask parse(Message message);

    void addNotificationTask(NotificationTask notificationTask);

    List<NotificationTask> findNotification();
}
