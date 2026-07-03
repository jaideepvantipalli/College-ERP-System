package menu;

import controller.NotificationController;
import enums.NotificationType;
import java.time.LocalDateTime;
import java.util.List;
import model.Notification;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

public class NotificationMenu {

    private final NotificationController controller;

    public NotificationMenu() {

        controller = new NotificationController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Notification Management");
            System.out.println("1. Send Notification");
            System.out.println("2. View Notifications");
            System.out.println("3. Search Notification");
            System.out.println("4. Update Notification");
            System.out.println("5. Delete Notification");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {

                case 1:
                    addNotification();
                    break;

                case 2:
                    viewNotifications();
                    break;

                case 3:
                    searchNotification();
                    break;

                case 4:
                    updateNotification();
                    break;

                case 5:
                    deleteNotification();
                    break;

                case 0:
                    return;

                default:
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

    private void addNotification() {

        Notification notification = new Notification();

        notification.setTitle(InputUtil.readString("Title : "));
        notification.setMessage(InputUtil.readString("Message : "));

        System.out.println("Target Role");
        System.out.println("1. ALL");
        System.out.println("2. STUDENT");
        System.out.println("3. FACULTY");

        int roleChoice = InputUtil.readInt("Choice : ");

        switch (roleChoice) {

            case 1:
                notification.setTargetRole(NotificationType.ALL);
                break;

            case 2:
                notification.setTargetRole(NotificationType.STUDENT);
                break;

            case 3:
                notification.setTargetRole(NotificationType.FACULTY);
                break;

            default:
                notification.setTargetRole(NotificationType.ALL);

        }

        notification.setCreatedBy(InputUtil.readInt("Created By (User ID): "));

        notification.setCreatedDate(LocalDateTime.now());

        if (controller.addNotification(notification)) {

            ConsolePrinter.success("Notification Sent Successfully.");

        } else {

            ConsolePrinter.error("Failed to Send Notification.");

        }

    }

    private void viewNotifications() {

        List<Notification> notifications = controller.getAllNotifications();

        if (notifications.isEmpty()) {

            ConsolePrinter.info("No Notifications Found.");

            return;

        }

        TablePrinter.heading("ID", "Title", "Message", "Target Role", "Created By", "Date");

        for (Notification n : notifications) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    n.getNotificationId(),
                    n.getTitle(),
                    n.getMessage(),
                    n.getTargetRole(),
                    n.getCreatedBy(),
                    n.getCreatedDate() != null ? n.getCreatedDate() : "N/A");

        }

        TablePrinter.line();

    }

    private void searchNotification() {

        int id = InputUtil.readInt("Notification ID : ");

        Notification n = controller.getNotificationById(id);

        if (n != null) {

            TablePrinter.heading("ID", "Title", "Message", "Target Role", "Created By", "Date");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    n.getNotificationId(),
                    n.getTitle(),
                    n.getMessage(),
                    n.getTargetRole(),
                    n.getCreatedBy(),
                    n.getCreatedDate() != null ? n.getCreatedDate() : "N/A");
            TablePrinter.line();

        } else {

            ConsolePrinter.error("Notification Not Found.");

        }

    }

    private void updateNotification() {

        int id = InputUtil.readInt("Notification ID : ");

        Notification notification = controller.getNotificationById(id);

        if (notification == null) {

            ConsolePrinter.error("Notification Not Found.");

            return;

        }

        notification.setTitle(InputUtil.readString("New Title : "));
        notification.setMessage(InputUtil.readString("New Message : "));

        System.out.println("Target Role");
        System.out.println("1. ALL");
        System.out.println("2. STUDENT");
        System.out.println("3. FACULTY");

        int roleChoice = InputUtil.readInt("Choice : ");

        switch (roleChoice) {

            case 1:
                notification.setTargetRole(NotificationType.ALL);
                break;

            case 2:
                notification.setTargetRole(NotificationType.STUDENT);
                break;

            case 3:
                notification.setTargetRole(NotificationType.FACULTY);
                break;

            default:
                break;

        }

        notification.setCreatedDate(LocalDateTime.now());

        if (controller.updateNotification(notification)) {

            ConsolePrinter.success("Notification Updated Successfully.");

        } else {

            ConsolePrinter.error("Update Failed.");

        }

    }

    private void deleteNotification() {

        int id = InputUtil.readInt("Notification ID : ");

        if (controller.deleteNotification(id)) {

            ConsolePrinter.success("Notification Deleted Successfully.");

        } else {

            ConsolePrinter.error("Delete Failed.");

        }

    }

}