package menu;

import controller.NotificationController;
import enums.NotificationType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import model.Notification;

public class NotificationMenu {

    private final Scanner scanner;
    private final NotificationController controller;

    public NotificationMenu() {

        scanner = new Scanner(System.in);
        controller = new NotificationController();

    }

    public void start() {

        while (true) {

            System.out.println("\n==================================");
            System.out.println(" NOTIFICATION MANAGEMENT ");
            System.out.println("==================================");
            System.out.println("1. Send Notification");
            System.out.println("2. View Notifications");
            System.out.println("3. Search Notification");
            System.out.println("4. Update Notification");
            System.out.println("5. Delete Notification");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

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
                    System.out.println("Invalid Choice.");

            }

        }

    }

    private void addNotification() {

        Notification notification = new Notification();

        System.out.print("Title : ");
        notification.setTitle(scanner.nextLine());

        System.out.print("Message : ");
        notification.setMessage(scanner.nextLine());

        System.out.println("Target Role");
        System.out.println("1. ALL");
        System.out.println("2. STUDENT");
        System.out.println("3. FACULTY");

        System.out.print("Choice : ");

        int roleChoice =
                Integer.parseInt(scanner.nextLine());

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

        System.out.print("Created By (User ID): ");

        notification.setCreatedBy(
                Integer.parseInt(scanner.nextLine()));

        notification.setCreatedDate(LocalDateTime.now());

        if (controller.addNotification(notification)) {

            System.out.println("\nNotification Sent Successfully.");

        } else {

            System.out.println("\nFailed to Send Notification.");

        }

    }

    private void viewNotifications() {

        List<Notification> notifications =
                controller.getAllNotifications();

        if (notifications.isEmpty()) {

            System.out.println("\nNo Notifications Found.");

            return;

        }

        for (Notification notification : notifications) {

            System.out.println(notification);

        }

    }

    private void searchNotification() {

        System.out.print("Notification ID : ");

        int id =
                Integer.parseInt(scanner.nextLine());

        Notification notification =
                controller.getNotificationById(id);

        if (notification != null) {

            System.out.println(notification);

        } else {

            System.out.println("Notification Not Found.");

        }

    }

    private void updateNotification() {

        System.out.print("Notification ID : ");

        int id =
                Integer.parseInt(scanner.nextLine());

        Notification notification =
                controller.getNotificationById(id);

        if (notification == null) {

            System.out.println("Notification Not Found.");

            return;

        }

        System.out.print("New Title : ");
        notification.setTitle(scanner.nextLine());

        System.out.print("New Message : ");
        notification.setMessage(scanner.nextLine());

        System.out.println("Target Role");
        System.out.println("1. ALL");
        System.out.println("2. STUDENT");
        System.out.println("3. FACULTY");

        int roleChoice =
                Integer.parseInt(scanner.nextLine());

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

            System.out.println("Notification Updated Successfully.");

        } else {

            System.out.println("Update Failed.");

        }

    }

    private void deleteNotification() {

        System.out.print("Notification ID : ");

        int id =
                Integer.parseInt(scanner.nextLine());

        if (controller.deleteNotification(id)) {

            System.out.println("Notification Deleted Successfully.");

        } else {

            System.out.println("Delete Failed.");

        }

    }

}