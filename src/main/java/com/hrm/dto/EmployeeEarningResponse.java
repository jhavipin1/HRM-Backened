package com.hrm.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeEarningResponse {
    private ResponseStatus responseStatus;
    private EmployeeEarningDTO employeeEarningDTO;
    private EmployeeDTO employeeDTO;

}
