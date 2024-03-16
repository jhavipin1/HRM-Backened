package com.hrm.dto;

import com.hrm.enums.Department;
import com.hrm.enums.Designation;
import com.hrm.enums.Gender;
import com.hrm.enums.Location;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EmployeeDTO {
    private Integer employeeId;
    private String employeeNo;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeMobileNumber;
    private String employeeEmailId;
    private Integer employeeAge;
    private Gender gender;
    private Date dob;
    private String panNo;
    private Date employeeDateOfJoining;
    private Date employeeDateOfLeaving;
    private Department department;
    private Designation designation;
    private Location location;

    private String employeeCreatedDate;
    private String employeeUpdatedDate;
}
