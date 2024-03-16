package com.hrm.service;

import com.hrm.dto.*;

import java.util.List;

public interface EmployeeEarningService {

    EmployeeEarningResponse addEmployeeEarningByEmployeeId(Integer employeeId, EmployeeEarningRequest employeeEarningRequest);
    List<EmployeeEarningResponse> getAllEmployeeEarning();

    EmployeeEarningResponse getEmployeeEarningByEarningId(Integer earningId);

}
