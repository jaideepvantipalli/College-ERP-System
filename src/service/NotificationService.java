package service;

import dao.NotificationDAO;
import dao.impl.NotificationDAOImpl;
import model.Notification;

import java.util.List;

public class NotificationService {

    private final NotificationDAO notificationDAO;

    public NotificationService() {

        notificationDAO = new NotificationDAOImpl();

    }

    public boolean addNotification(Notification notification) {

        return notificationDAO.addNotification(notification);

    }

    public List<Notification> getAllNotifications() {

        return notificationDAO.getAllNotifications();

    }

    public Notification getNotificationById(int id) {

        return notificationDAO.getNotificationById(id);

    }

    public boolean updateNotification(Notification notification) {

        return notificationDAO.updateNotification(notification);

    }

    public boolean deleteNotification(int id) {

        return notificationDAO.deleteNotification(id);

    }

}