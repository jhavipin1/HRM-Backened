package com.hrm.dto;

import com.hrm.entity.Employee;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeDeductionDTO {
    private Integer deductionId;
    private String deductionYearMonth;
    private Long pfAmount;
    private Long incomeTax;
    private Long otherDeduction;
    private String createdDate;

    private String updatedDate;
}
