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
public class EmployeeEarning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private Employee employee;

    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;



}
