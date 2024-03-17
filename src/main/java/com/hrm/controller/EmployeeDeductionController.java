package com.hrm.controller;

import com.hrm.dto.EmployeeDeductionRequest;
import com.hrm.dto.EmployeeEarningRequest;
import com.hrm.dto.ResponseDTO;
import com.hrm.enums.MessageProperties;
import com.hrm.service.EmployeeDeductionService;
import com.hrm.service.EmployeeEarningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeDeduction")
@Slf4j
public class EmployeeDeductionController {
    @Autowired
    private EmployeeDeductionService employeeDeductionService;
    @PostMapping("/add/employee/{empId}")
    public ResponseEntity<ResponseDTO> addEmployeeDeductionByTd(@PathVariable("empId") Integer empId, @RequestBody EmployeeDeductionRequest request) {
        ResponseDTO response = new ResponseDTO(MessageProperties.ADDED_ADDRESS.getMessage(),
                employeeDeductionService.addEmployeeDeductionByEmployeeId(empId, request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllEmployeeDeductionDetails() {
        ResponseDTO responseDTO = new ResponseDTO("All Employee Earning Fetched Successfully!",
                employeeDeductionService.getAllEmployeeDeduction());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{deductionId}")
    public ResponseEntity<ResponseDTO> getEmployeeDeductionByEarningId(@PathVariable("deductionId") Integer deductionId) {
        log.info("Inside Employee Controller getEmployeeById() method, EmployeeId : {}", deductionId);
        ResponseDTO response = new ResponseDTO(MessageProperties.FETCHED_EMPLOYEE.getMessage(),
                employeeDeductionService.getEmployeeDeductionByEarningId(deductionId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
