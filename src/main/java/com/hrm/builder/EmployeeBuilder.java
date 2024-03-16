package com.hrm.builder;

import com.hrm.dto.*;
import com.hrm.entity.Employee;
import com.hrm.enums.Department;
import com.hrm.enums.Designation;
import com.hrm.enums.Gender;
import com.hrm.enums.Location;
import com.hrm.utils.AppUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeBuilder {

    public Employee getEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .employeeNo(employeeRequest.getEmployeeNo())
                .firstName(employeeRequest.getEmployeeFirstName())
                .lastName(employeeRequest.getEmployeeLastName())
                .emailId(employeeRequest.getEmployeeEmailId())
                .mobileNumber(employeeRequest.getEmployeeMobileNumber())
                .age(employeeRequest.getEmployeeAge())
                .gender(employeeRequest.getGender().name())
                .dob(employeeRequest.getDob())
                .panNo(employeeRequest.getPanNo())
                .dateofJoining(employeeRequest.getEmployeeDateOfJoining())
                .dateofLeaving(employeeRequest.getEmployeeDateOfLeaving())
                .department(employeeRequest.getDepartment().name())
                .designation(employeeRequest.getDesignation().name())
                .location(employeeRequest.getLocation().name())
                .build();
    }
    public EmployeeResponse getEmployeeResponse(Employee employee) {
        AddressBuilder addressBuilder = new AddressBuilder();
        boolean isDataSaved = Optional.ofNullable(employee).isPresent();
        ResponseStatus responseStatus = isDataSaved ? AppUtils.getSuccessStatus() : AppUtils.getErrorStatus();
        List<AddressDTO> addressDTOList = null;
        if (employee.getAddresses() != null) {
            addressDTOList = employee.getAddresses()
                    .stream()
                    .map(address -> addressBuilder.getAddressDTO(address))
                    .collect(Collectors.toList());
        }
        EmployeeEarningBuilder employeeEarningBuilder=new EmployeeEarningBuilder();
        List<EmployeeEarningDTO> employeeEarningDTOList = null;
        if (employee.getEmployeeEarningList() != null) {
            employeeEarningDTOList= employee.getEmployeeEarningList()
                    .stream()
                    .map(employeeEarning -> employeeEarningBuilder.getEmployeeEarningDTO(employeeEarning))
                    .collect(Collectors.toList());
        }
        EmployeeDeductionBuilder employeeDeductionBuilder=new EmployeeDeductionBuilder();
        List<EmployeeDeductionDTO> employeeDeductionDTOList = null;
        if (employee.getEmployeeDeductionsList() != null) {
            employeeDeductionDTOList= employee.getEmployeeDeductionsList()
                    .stream()
                    .map(employeeDeduction ->  employeeDeductionBuilder.getEmployeeDeductionDTO(employeeDeduction))
                    .collect(Collectors.toList());
        }

        return EmployeeResponse.builder()
                .employeeDTO(getEmployeeDTO(employee))
                .addressDTOS(addressDTOList)
                .employeeEarningDTOS(employeeEarningDTOList)
                .employeeDeductionDTOS(employeeDeductionDTOList)
                .responseStatus(responseStatus)
                .build();
    }

    public EmployeeDTO getEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .employeeId(employee.getEmpId())
                .employeeNo(employee.getEmployeeNo())
                .employeeFirstName(employee.getFirstName())
                .employeeLastName(employee.getLastName())
                .employeeAge(employee.getAge())
                .employeeEmailId(employee.getEmailId())
                .employeeMobileNumber(employee.getMobileNumber())
                .gender(Gender.valueOf(employee.getGender()))
                .dob(employee.getDob())
                .panNo(employee.getPanNo())
                .employeeDateOfJoining(employee.getDateofJoining())
                .employeeDateOfLeaving(employee.getDateofLeaving())
                .department(Department.valueOf(employee.getDepartment()))
                .designation(Designation.valueOf(employee.getDesignation()))
                .location(Location.valueOf(employee.getLocation()))
                .employeeCreatedDate(AppUtils.getStringFormattedDate(employee.getCreatedDate()))
                .employeeUpdatedDate(AppUtils.getStringFormattedDate(employee.getCreatedDate()))
                .build();
    }
}
