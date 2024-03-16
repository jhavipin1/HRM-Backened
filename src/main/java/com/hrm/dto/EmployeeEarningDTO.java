package com.hrm.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeEarningDTO {
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

    private String createdDate;
    private String updatedDate;

}
