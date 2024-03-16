package com.hrm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String employeeNo;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private Integer age;
    private String gender;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dob;
    private String panNo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateofJoining;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateofLeaving;
    private String department;
    private String designation;
    private String location;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeEarning> employeeEarningList;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;

}
