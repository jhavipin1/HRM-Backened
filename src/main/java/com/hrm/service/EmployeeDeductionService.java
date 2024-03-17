package com.hrm.service;

import com.hrm.dto.EmployeeDeductionRequest;
import com.hrm.dto.EmployeeDeductionResponse;


import java.util.List;

public interface EmployeeDeductionService {

    EmployeeDeductionResponse addEmployeeDeductionByEmployeeId(Integer employeeId, EmployeeDeductionRequest employeeDeductionRequest);
    List<EmployeeDeductionResponse> getAllEmployeeDeduction();

    EmployeeDeductionResponse getEmployeeDeductionByEarningId(Integer earningId);
}
