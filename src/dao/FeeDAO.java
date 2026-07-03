package dao;

import model.Fee;

import java.util.List;

public interface FeeDAO {

    boolean addFee(Fee fee);

    List<Fee> getAllFees();

    Fee getFeeById(int feeId);

    List<Fee> getFeeByStudent(int studentId);

    boolean updateFee(Fee fee);

    boolean deleteFee(int feeId);

}