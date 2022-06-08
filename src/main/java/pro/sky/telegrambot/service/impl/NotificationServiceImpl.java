package pro.sky.telegrambot.service.impl;

import com.pengrad.telegrambot.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.listener.TelegramBotUpdatesListener;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.repository.NotificationRepository;
import pro.sky.telegrambot.service.NotificationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NotificationServiceImpl implements NotificationService {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    private final NotificationRepository notificationRepository;

    private final String REGEX = "([0-9\\.\\:\\s]{16})(\\s)([\\W+]+)";

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationTask parse(Message message) {
        NotificationTask notificationTask = null;
        String text = message.text();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        Long chatId = message.chat().id();

        try {
            if (matcher.matches()) {
                String dataTime = matcher.group(1);
                String notification = matcher.group(3);
                LocalDateTime sign_up_date = LocalDateTime.parse(dataTime, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                notificationTask = new NotificationTask(chatId, notification, sign_up_date);
                notificationTask.setReceived_date(LocalDateTime.now());

            }
        } catch (Exception e) {
            logger.error("Enter another message");
        }

        return notificationTask;
    }

    @Override
    public void addNotificationTask(NotificationTask notificationTask) {
        if (notificationTask == null) {
            throw new NullPointerException();
        }
        notificationRepository.save(notificationTask);
    }

    @Override
    public List<NotificationTask> findNotification() {
        return notificationRepository.getNotifications();
    }


}
