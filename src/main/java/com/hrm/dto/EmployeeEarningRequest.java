package com.hrm.dto;

import lombok.Data;

@Data
public class EmployeeEarningRequest {
    private Integer earningId;
    private String earningYearMonth;
    private Long basic;
    private Long hra;
    private Long specialAllowance;
    private Long ltaAllowance;
    private Long mealAllowance;
    private Long booksPeriodicals;
    private Long carFuel;
    private Long driver;
    private Long telephone;
    private Long anniversaryGift;
}
