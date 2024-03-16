package com.hrm.controller;

import com.hrm.dto.AddressRequest;
import com.hrm.dto.EmployeeEarningRequest;
import com.hrm.dto.EmployeeRequest;
import com.hrm.dto.ResponseDTO;
import com.hrm.enums.MessageProperties;
import com.hrm.service.EmployeeEarningService;
import com.hrm.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeEarning")
@Slf4j
public class EmployeeEarningController {

    @Autowired
    private EmployeeEarningService employeeEarningService;
    @PostMapping("/add/employee/{empId}")
    public ResponseEntity<ResponseDTO> addEmployeeEarningByTd(@PathVariable("empId") Integer empId, @RequestBody EmployeeEarningRequest request) {
        ResponseDTO response = new ResponseDTO(MessageProperties.ADDED_ADDRESS.getMessage(),
                employeeEarningService.addEmployeeEarningByEmployeeId(empId, request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllEmployeeEarningDetails() {
        ResponseDTO responseDTO = new ResponseDTO("All Employee Earning Fetched Successfully!",
                employeeEarningService.getAllEmployeeEarning());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{earningId}")
    public ResponseEntity<ResponseDTO> getEmployeeEarningByEarningId(@PathVariable("earningId") Integer earningId) {
        log.info("Inside Employee Controller getEmployeeById() method, EmployeeId : {}", earningId);
        ResponseDTO response = new ResponseDTO(MessageProperties.FETCHED_EMPLOYEE.getMessage(),
                employeeEarningService.getEmployeeEarningByEarningId(earningId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}