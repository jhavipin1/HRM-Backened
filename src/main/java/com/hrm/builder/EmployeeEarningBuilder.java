package com.hrm.builder;

import com.hrm.dto.*;
import com.hrm.entity.Employee;
import com.hrm.entity.EmployeeEarning;
import com.hrm.utils.AppUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeEarningBuilder {
    public EmployeeEarning getEmployeeEarning(EmployeeEarningRequest employeeEarningRequest) {
        return EmployeeEarning.builder()
                .earningId(employeeEarningRequest.getEarningId())
                .earningYearMonth(employeeEarningRequest.getEarningYearMonth())
                .basic(employeeEarningRequest.getBasic())
                .hra(employeeEarningRequest.getHra())
                .specialAllowance(employeeEarningRequest.getSpecialAllowance())
                .ltaAllowance(employeeEarningRequest.getLtaAllowance())
                .mealAllowance(employeeEarningRequest.getMealAllowance())
                .booksPeriodicals(employeeEarningRequest.getBooksPeriodicals())
                .carFuel(employeeEarningRequest.getCarFuel())
                .driver(employeeEarningRequest.getDriver())
                .telephone(employeeEarningRequest.getTelephone())
                .anniversaryGift(employeeEarningRequest.getAnniversaryGift())
                .build();
    }

    public EmployeeEarningResponse getEmployeeEarningResponse(EmployeeEarning employeeEarning) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        boolean isDataSaved = Optional.ofNullable(employeeEarning).isPresent();
        ResponseStatus responseStatus = isDataSaved ? AppUtils.getSuccessStatus() : AppUtils.getErrorStatus();
        EmployeeDTO getEmployeeDTO = null;
        if (employeeEarning.getEmployee() != null)
            getEmployeeDTO = employeeBuilder.getEmployeeDTO(employeeEarning.getEmployee());
        return EmployeeEarningResponse.builder()
                .employeeEarningDTO(getEmployeeEarningDTO(employeeEarning))
                .employeeDTO(getEmployeeDTO)
                .responseStatus(responseStatus)
                .build();


    }

    public EmployeeEarningDTO getEmployeeEarningDTO(EmployeeEarning employeeEarning) {
        return EmployeeEarningDTO.builder()
                .earningId(employeeEarning.getEarningId())
                .earningYearMonth(employeeEarning.getEarningYearMonth())
                .basic(employeeEarning.getBasic())
                .hra(employeeEarning.getHra())
                .specialAllowance(employeeEarning.getSpecialAllowance())
                .ltaAllowance(employeeEarning.getLtaAllowance())
                .mealAllowance(employeeEarning.getMealAllowance())
                .booksPeriodicals(employeeEarning.getBooksPeriodicals())
                .carFuel(employeeEarning.getCarFuel())
                .driver(employeeEarning.getDriver())
                .telephone(employeeEarning.getTelephone())
                .anniversaryGift(employeeEarning.getAnniversaryGift())
                .createdDate(AppUtils.getStringFormattedDate(employeeEarning.getCreatedDate()))
                .updatedDate(AppUtils.getStringFormattedDate(employeeEarning.getUpdatedDate()))
                .build();
    }
}
