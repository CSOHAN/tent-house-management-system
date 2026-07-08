package com.thms.tenthouse.customer.service;

import com.thms.tenthouse.common.exceptions.CustomerAlreadyExistsException;
import com.thms.tenthouse.common.exceptions.CustomerNotFoundException;
import com.thms.tenthouse.customer.dto.CustomerRequestDto;
import com.thms.tenthouse.customer.dto.CustomerResponseDto;
import com.thms.tenthouse.customer.entity.Customer;
import com.thms.tenthouse.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {

        Customer customer = Customer.builder()
            .name(requestDto.getName())
            .mobileNumber(requestDto.getMobileNumber())
            .place(requestDto.getPlace())
            .build();

        Customer savedCustomer = customerRepository.save(customer);

        return mapToResponse(savedCustomer);
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {

        return customerRepository.findAll()
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapToResponse(customer);
    }

    @Override
    public CustomerResponseDto updateCustomer(Long id,
                                              CustomerRequestDto requestDto) {

        Customer customer = customerRepository.findById(id)
            .orElseThrow(() ->
                new CustomerNotFoundException("Customer not found"));

        // Check if mobile number already belongs to another customer
        Customer existingCustomer =
            customerRepository.findByMobileNumber(
                    requestDto.getMobileNumber())
                .orElse(null);

        if (existingCustomer != null &&
            !existingCustomer.getCustomerId().equals(id)) {
            throw new CustomerAlreadyExistsException(
                "Customer with mobile number already exists");
        }

        customer.setName(requestDto.getName());
        customer.setMobileNumber(requestDto.getMobileNumber());
        customer.setPlace(requestDto.getPlace());

        Customer updatedCustomer = customerRepository.save(customer);

        return mapToResponse(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {

        customerRepository.deleteById(id);
    }

    private CustomerResponseDto mapToResponse(Customer customer) {

        return CustomerResponseDto.builder()
            .customerId(customer.getCustomerId())
            .name(customer.getName())
            .mobileNumber(customer.getMobileNumber())
            .place(customer.getPlace())
            .createdAt(customer.getCreatedAt())
            .updatedAt(customer.getUpdatedAt())
            .build();
    }

    @Override
    public CustomerResponseDto
    getCustomerByMobileNumber(String mobileNumber) {

        Customer customer = customerRepository
            .findByMobileNumber(mobileNumber)
            .orElseThrow(() ->
                new RuntimeException(
                    "Customer not found"));

        return CustomerResponseDto.builder()
            .customerId(customer.getCustomerId())
            .name(customer.getName())
            .mobileNumber(customer.getMobileNumber())
            .place(customer.getPlace())
            .createdAt(customer.getCreatedAt())
            .updatedAt(customer.getUpdatedAt())
            .build();
    }

    @Override
    public List<CustomerResponseDto>
    searchCustomersByName(String name) {

        return customerRepository
            .findByNameContainingIgnoreCase(name)
            .stream()
            .map(this::mapToResponse)
            .toList();
    }
}
