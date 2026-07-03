package dao;

import model.Notification;

import java.util.List;

public interface NotificationDAO {

    boolean addNotification(Notification notification);

    List<Notification> getAllNotifications();

    Notification getNotificationById(int notificationId);

    boolean updateNotification(Notification notification);

    boolean deleteNotification(int notificationId);

}