package com.hrm.service.serviceImpl;

import com.hrm.builder.EmployeeDeductionBuilder;
import com.hrm.builder.EmployeeEarningBuilder;
import com.hrm.constant.AppConstant;
import com.hrm.dto.EmployeeDeductionRequest;
import com.hrm.dto.EmployeeDeductionResponse;
import com.hrm.entity.Employee;
import com.hrm.entity.EmployeeDeduction;
import com.hrm.entity.EmployeeEarning;
import com.hrm.enums.MessageProperties;
import com.hrm.exception.EmployeeNotFoundException;
import com.hrm.repo.EmployeeDeductionRepo;
import com.hrm.repo.EmployeeEarningRepo;
import com.hrm.repo.EmployeeRepo;
import com.hrm.service.CommonService;
import com.hrm.service.EmployeeDeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeDeductionServiceImpl implements EmployeeDeductionService {

    @Autowired
    private EmployeeDeductionRepo employeeDeductionRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeDeductionBuilder employeeDeductionBuilder;
    @Override
    public EmployeeDeductionResponse addEmployeeDeductionByEmployeeId(Integer employeeId, EmployeeDeductionRequest employeeDeductionRequest) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        AppConstant.NOT_FOUND));
        EmployeeDeduction employeeDeduction = employeeDeductionBuilder.getEmployeeDeduction(employeeDeductionRequest);
        employeeDeduction.setEmployee(employee);
        employeeDeduction = employeeDeductionRepo.save(employeeDeduction);
        return employeeDeductionBuilder.getEmployeeDeductionResponse(employeeDeduction);
    }

    @Override
    public List<EmployeeDeductionResponse> getAllEmployeeDeduction() {
        return employeeDeductionRepo.findAll()
                .stream()
                .map(employeeDeductionInfo -> employeeDeductionBuilder.getEmployeeDeductionResponse(employeeDeductionInfo))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDeductionResponse getEmployeeDeductionByEarningId(Integer earningId) {
        EmployeeDeduction employeeDeduction = employeeDeductionRepo.findById(earningId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        AppConstant.NOT_FOUND));
        return employeeDeductionBuilder.getEmployeeDeductionResponse(employeeDeduction);
    }
}
