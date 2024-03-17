package com.hrm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDeductionResponse {
    private ResponseStatus responseStatus;
    private EmployeeDeductionDTO employeeDeductionDTO;
    private EmployeeDTO employeeDTO;
}
