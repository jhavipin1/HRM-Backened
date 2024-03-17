package com.hrm.repo;

import com.hrm.entity.EmployeeDeduction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDeductionRepo extends JpaRepository<EmployeeDeduction, Integer> {
}
