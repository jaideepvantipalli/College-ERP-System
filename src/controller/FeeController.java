package controller;

import model.Fee;
import service.FeeService;

import java.util.List;

public class FeeController {

    private final FeeService feeService;

    public FeeController() {

        feeService = new FeeService();

    }

    public boolean addFee(Fee fee) {

        return feeService.addFee(fee);

    }

    public List<Fee> getAllFees() {

        return feeService.getAllFees();

    }

    public Fee getFeeById(int feeId) {

        return feeService.getFeeById(feeId);

    }

    public List<Fee> getFeeByStudent(int studentId) {

        return feeService.getFeeByStudent(studentId);

    }

    public boolean updateFee(Fee fee) {

        return feeService.updateFee(fee);

    }

    public boolean deleteFee(int feeId) {

        return feeService.deleteFee(feeId);

    }

}