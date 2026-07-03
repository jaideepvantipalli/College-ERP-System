package controller;

import model.Notification;
import service.NotificationService;

import java.util.List;

public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController() {

        notificationService = new NotificationService();

    }

    public boolean addNotification(Notification notification) {

        return notificationService.addNotification(notification);

    }

    public List<Notification> getAllNotifications() {

        return notificationService.getAllNotifications();

    }

    public Notification getNotificationById(int notificationId) {

        return notificationService.getNotificationById(notificationId);

    }

    public boolean updateNotification(Notification notification) {

        return notificationService.updateNotification(notification);

    }

    public boolean deleteNotification(int notificationId) {

        return notificationService.deleteNotification(notificationId);

    }

}