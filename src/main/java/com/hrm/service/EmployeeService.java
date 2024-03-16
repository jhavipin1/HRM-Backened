package com.hrm.service;

import com.hrm.dto.EmployeeRequest;
import com.hrm.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployee();

    EmployeeResponse getEmployeeById(Integer employeeId);

    EmployeeResponse updateEmployeeById(Integer empId, EmployeeRequest request);

    Integer deleteEmployeeById(Integer empId);
}
