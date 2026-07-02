package model;

import java.time.LocalDateTime;
import java.util.Objects;
import enums.NotificationType;

/**
 * Model class representing Notification.
 * Maps to the 'notifications' table.
 *
 * Author : Jaideep
 * Project : College ERP Management System
 */
public class Notification {

    private int notificationId;
    private String title;
    private String message;
    private NotificationType targetRole;
    private int createdBy;
    private LocalDateTime createdDate;

    // Default Constructor
    public Notification() {
    }

    // Parameterized Constructor
    public Notification(int notificationId,
                        String title,
                        String message,
                        NotificationType targetRole,
                        int createdBy,
                        LocalDateTime createdDate) {

        this.notificationId = notificationId;
        this.title = title;
        this.message = message;
        this.targetRole = targetRole;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    // Getters

    public int getNotificationId() {
        return notificationId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getTargetRole() {
        return targetRole;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    // Setters

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTargetRole(NotificationType targetRole) {
        this.targetRole = targetRole;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", targetRole='" + targetRole + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Notification))
            return false;

        Notification notification = (Notification) obj;

        return notificationId == notification.notificationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId);
    }

}