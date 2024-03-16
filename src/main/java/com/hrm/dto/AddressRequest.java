package com.hrm.dto;

import com.hrm.enums.AddressType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter@Setter
public class AddressRequest {
    private String city;
    private String state;
    private String pinCode;
    private AddressType addressType;
}
