package service;

import dao.FeeDAO;
import dao.impl.FeeDAOImpl;
import model.Fee;

import java.util.List;

public class FeeService {

    private final FeeDAO feeDAO;

    public FeeService() {

        feeDAO = new FeeDAOImpl();

    }

    public boolean addFee(Fee fee) {

        return feeDAO.addFee(fee);

    }

    public List<Fee> getAllFees() {

        return feeDAO.getAllFees();

    }

    public Fee getFeeById(int feeId) {

        return feeDAO.getFeeById(feeId);

    }

    public List<Fee> getFeeByStudent(int studentId) {

        return feeDAO.getFeeByStudent(studentId);

    }

    public boolean updateFee(Fee fee) {

        return feeDAO.updateFee(fee);

    }

    public boolean deleteFee(int feeId) {

        return feeDAO.deleteFee(feeId);

    }

}