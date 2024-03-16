package com.hrm.repo;


import com.hrm.entity.EmployeeEarning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEarningRepo extends JpaRepository<EmployeeEarning, Integer> {
}
