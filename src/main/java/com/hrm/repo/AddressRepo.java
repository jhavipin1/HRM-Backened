package com.hrm.repo;

import com.hrm.entity.Address;
import com.hrm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    List<Address> findByEmployee(Employee employee);
}
