package com.hrm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDeduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deductionId;
    private String deductionYearMonth;
    private Long pfAmount;
    private Long incomeTax;
    private Long otherDeduction;
    @ManyToOne
    private Employee employee;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
