package com.hrm.builder;

import com.hrm.dto.*;
import com.hrm.entity.EmployeeDeduction;
import com.hrm.entity.EmployeeEarning;
import com.hrm.utils.AppUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeDeductionBuilder {
    public EmployeeDeduction getEmployeeDeduction(EmployeeDeductionRequest employeeDeductionRequest) {
        return EmployeeDeduction.builder()
                .deductionId(employeeDeductionRequest.getDeductionId())
                .deductionYearMonth(employeeDeductionRequest.getDeductionYearMonth())
                .pfAmount(employeeDeductionRequest.getPfAmount())
                .incomeTax(employeeDeductionRequest.getIncomeTax())
                .otherDeduction(employeeDeductionRequest.getOtherDeduction())
                .build();
    }

    public EmployeeDeductionResponse getEmployeeDeductionResponse(EmployeeDeduction employeeDeduction) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        boolean isDataSaved = Optional.ofNullable(employeeDeduction).isPresent();
        ResponseStatus responseStatus = isDataSaved ? AppUtils.getSuccessStatus() : AppUtils.getErrorStatus();
        EmployeeDTO getEmployeeDTO = null;
        if (employeeDeduction.getEmployee() != null)
            getEmployeeDTO = employeeBuilder.getEmployeeDTO(employeeDeduction.getEmployee());
        return EmployeeDeductionResponse.builder()
                .employeeDeductionDTO(getEmployeeDeductionDTO(employeeDeduction))
                .employeeDTO(getEmployeeDTO)
                .responseStatus(responseStatus)
                .build();


    }

    public EmployeeDeductionDTO getEmployeeDeductionDTO(EmployeeDeduction employeeDeduction) {
        return EmployeeDeductionDTO.builder()
                .deductionId(employeeDeduction.getDeductionId())
                .deductionYearMonth(employeeDeduction.getDeductionYearMonth())
                .pfAmount(employeeDeduction.getPfAmount())
                .incomeTax(employeeDeduction.getIncomeTax())
                .otherDeduction(employeeDeduction.getOtherDeduction())
                .createdDate(AppUtils.getStringFormattedDate(employeeDeduction.getCreatedDate()))
                .updatedDate(AppUtils.getStringFormattedDate(employeeDeduction.getUpdatedDate()))
                .build();
    }
}
