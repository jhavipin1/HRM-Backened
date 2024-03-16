package com.hrm.service.serviceImpl;

import com.hrm.builder.EmployeeBuilder;
import com.hrm.builder.EmployeeEarningBuilder;
import com.hrm.constant.AppConstant;
import com.hrm.dto.EmployeeEarningRequest;
import com.hrm.dto.EmployeeEarningResponse;
import com.hrm.dto.EmployeeResponse;
import com.hrm.entity.Address;
import com.hrm.entity.Employee;
import com.hrm.entity.EmployeeEarning;
import com.hrm.enums.MessageProperties;
import com.hrm.exception.EmployeeNotFoundException;
import com.hrm.repo.EmployeeEarningRepo;
import com.hrm.repo.EmployeeRepo;
import com.hrm.service.CommonService;
import com.hrm.service.EmployeeEarningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeEarningServiceImpl implements EmployeeEarningService {

    @Autowired
    private EmployeeEarningRepo employeeEarningRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private EmployeeEarningBuilder employeeEarningBuilder;

    @Override
    public EmployeeEarningResponse addEmployeeEarningByEmployeeId(Integer employeeId, EmployeeEarningRequest employeeEarningRequest) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        AppConstant.NOT_FOUND));
        EmployeeEarning employeeEarning = employeeEarningBuilder.getEmployeeEarning(employeeEarningRequest);
        employeeEarning.setEmployee(employee);
        employeeEarning = employeeEarningRepo.save(employeeEarning);
        return employeeEarningBuilder.getEmployeeEarningResponse(employeeEarning);
    }


    @Override
    public List<EmployeeEarningResponse> getAllEmployeeEarning() {
        return employeeEarningRepo.findAll()
                .stream()
                .map(employeeEarningInfo -> employeeEarningBuilder.getEmployeeEarningResponse(employeeEarningInfo))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeEarningResponse getEmployeeEarningByEarningId(Integer earningId) {
        EmployeeEarning employeeEarning = employeeEarningRepo.findById(earningId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        AppConstant.NOT_FOUND));
        return employeeEarningBuilder.getEmployeeEarningResponse(employeeEarning);
    }


}
