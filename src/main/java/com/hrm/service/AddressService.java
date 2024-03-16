package com.hrm.service;

import com.hrm.dto.AddressRequest;
import com.hrm.dto.AddressResponse;

import java.util.List;

public interface AddressService {
    AddressResponse addAddress(Integer employeeId, AddressRequest request);

    List<AddressResponse> getAllAddressByEmployee(Integer empId);

    List<AddressResponse> getAllAddress();

    AddressResponse updateAddressById(Integer addressId, AddressRequest addressRequest);

    Integer deleteAddressById(Integer addressId);

}
