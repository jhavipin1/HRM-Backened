package com.hrm.dto;

import com.hrm.enums.AddressType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private Integer addressId;
    private String city;
    private String state;
    private String pinCode;
    private AddressType addressType;
    private String addressCreatedDate;
    private String addressUpdatedDate;
}
