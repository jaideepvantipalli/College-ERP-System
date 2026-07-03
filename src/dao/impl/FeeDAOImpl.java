package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.FeeDAO;
import enums.FeeStatus;
import model.Fee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeeDAOImpl implements FeeDAO {

    private Fee mapFee(ResultSet rs) throws SQLException {

        Fee fee = new Fee();

        fee.setFeeId(rs.getInt("fee_id"));
        fee.setStudentId(rs.getInt("student_id"));
        fee.setTotalFee(rs.getDouble("total_fee"));
        fee.setPaidFee(rs.getDouble("paid_fee"));
        fee.setBalance(rs.getDouble("balance"));
        fee.setPaymentDate(rs.getDate("payment_date").toLocalDate());
        fee.setStatus(FeeStatus.valueOf(rs.getString("status")));

        return fee;
    }

    @Override
    public boolean addFee(Fee fee) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.INSERT_FEE);

            ps.setInt(1, fee.getStudentId());
            ps.setDouble(2, fee.getTotalFee());
            ps.setDouble(3, fee.getPaidFee());
            ps.setDouble(4, fee.getBalance());
            ps.setDate(5, Date.valueOf(fee.getPaymentDate()));
            ps.setString(6, fee.getStatus().name());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public List<Fee> getAllFees() {

        List<Fee> fees = new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_ALL_FEES);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                fees.add(mapFee(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return fees;
    }

    @Override
    public Fee getFeeById(int feeId) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_FEE_BY_ID);

            ps.setInt(1, feeId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return mapFee(rs);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    @Override
    public List<Fee> getFeeByStudent(int studentId) {

        List<Fee> fees = new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_FEE_BY_STUDENT);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                fees.add(mapFee(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return fees;
    }

    @Override
    public boolean updateFee(Fee fee) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.UPDATE_FEE);

            ps.setInt(1, fee.getStudentId());
            ps.setDouble(2, fee.getTotalFee());
            ps.setDouble(3, fee.getPaidFee());
            ps.setDouble(4, fee.getBalance());
            ps.setDate(5, Date.valueOf(fee.getPaymentDate()));
            ps.setString(6, fee.getStatus().name());
            ps.setInt(7, fee.getFeeId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean deleteFee(int feeId) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.DELETE_FEE);

            ps.setInt(1, feeId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

}