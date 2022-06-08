package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.sky.telegrambot.model.NotificationTask;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationTask,Long> {

    @Query(value = "select * FROM notification_task where received_date < current_timestamp", nativeQuery = true)
    List<NotificationTask> getNotifications();


}
