package com.hrm.dto;

import com.hrm.entity.EmployeeDeduction;
import lombok.*;

import java.util.List;

@Data
@Builder
public class EmployeeResponse {
    private ResponseStatus responseStatus;
    private EmployeeDTO employeeDTO;
    List<AddressDTO> addressDTOS;
    List<EmployeeEarningDTO> employeeEarningDTOS;
    List<EmployeeDeductionDTO> employeeDeductionDTOS;


}
