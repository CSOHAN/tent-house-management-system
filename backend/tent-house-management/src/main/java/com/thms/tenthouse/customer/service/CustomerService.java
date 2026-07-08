package com.thms.tenthouse.customer.service;

import com.thms.tenthouse.customer.dto.CustomerRequestDto;
import com.thms.tenthouse.customer.dto.CustomerResponseDto;
import com.thms.tenthouse.customer.entity.Customer;
import java.util.List;

public interface CustomerService {CustomerResponseDto createCustomer(CustomerRequestDto requestDto);

    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(Long id);

    CustomerResponseDto updateCustomer(Long id, CustomerRequestDto requestDto);

    void deleteCustomer(Long id);

    CustomerResponseDto getCustomerByMobileNumber(String mobileNumber);

    List<CustomerResponseDto> searchCustomersByName(String name);
}
