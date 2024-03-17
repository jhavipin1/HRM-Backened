package com.hrm.dto;

import lombok.Data;

@Data
public class EmployeeDeductionRequest {
    private Integer deductionId;
    private String deductionYearMonth;
    private Long pfAmount;
    private Long incomeTax;
    private Long otherDeduction;
}
