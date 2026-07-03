package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.NotificationDAO;
import enums.NotificationType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Notification;

public class NotificationDAOImpl implements NotificationDAO {

    private Notification mapNotification(ResultSet rs) throws SQLException {

        Notification notification = new Notification();

        notification.setNotificationId(rs.getInt("notification_id"));
        notification.setTitle(rs.getString("title"));
        notification.setMessage(rs.getString("message"));

        notification.setTargetRole(
                NotificationType.valueOf(
                        rs.getString("target_role")));

        notification.setCreatedBy(
                rs.getInt("created_by"));

        Timestamp timestamp =
                rs.getTimestamp("created_date");

        if (timestamp != null) {

            notification.setCreatedDate(
                    timestamp.toLocalDateTime());

        }

        return notification;
    }

    @Override

    public boolean addNotification(Notification notification) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.INSERT_NOTIFICATION)) {

            ps.setString(1, notification.getTitle());

            ps.setString(2, notification.getMessage());

            ps.setString(3, notification.getTargetRole().name());

            ps.setInt(4, notification.getCreatedBy());

            if (notification.getCreatedDate() != null) {

                ps.setTimestamp(5, Timestamp.valueOf(notification.getCreatedDate()));

            } else {

                ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

            }

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override

    public List<Notification> getAllNotifications() {

        List<Notification> list = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.GET_ALL_NOTIFICATIONS);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                list.add(mapNotification(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return list;

    }

    @Override

    public Notification getNotificationById(int notificationId) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.GET_NOTIFICATION_BY_ID)) {

            ps.setInt(1, notificationId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return mapNotification(rs);

                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override

    public boolean updateNotification(Notification notification) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.UPDATE_NOTIFICATION)) {

            ps.setString(1, notification.getTitle());

            ps.setString(2, notification.getMessage());

            ps.setString(3, notification.getTargetRole().name());

            ps.setInt(4, notification.getCreatedBy());

            if (notification.getCreatedDate() != null) {

                ps.setTimestamp(5, Timestamp.valueOf(notification.getCreatedDate()));

            } else {

                ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

            }

            ps.setInt(6, notification.getNotificationId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override

    public boolean deleteNotification(int notificationId) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.DELETE_NOTIFICATION)) {

            ps.setInt(1, notificationId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

}