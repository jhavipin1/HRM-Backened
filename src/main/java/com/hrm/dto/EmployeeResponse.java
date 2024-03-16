package com.hrm.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
public class EmployeeResponse {
    private ResponseStatus responseStatus;
    private EmployeeDTO employeeDTO;
    List<AddressDTO> addressDTOS;
    List<EmployeeEarningDTO> employeeEarningDTOS;


}
