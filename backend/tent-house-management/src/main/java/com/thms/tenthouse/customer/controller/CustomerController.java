package com.thms.tenthouse.customer.controller;

import com.thms.tenthouse.customer.dto.CustomerRequestDto;
import com.thms.tenthouse.customer.dto.CustomerResponseDto;
import com.thms.tenthouse.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponseDto createCustomer(
        @Valid @RequestBody CustomerRequestDto requestDto) {
        return customerService.createCustomer(requestDto);
    }

    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto updateCustomer(
        @PathVariable Long id,
        @Valid @RequestBody CustomerRequestDto requestDto) {

        return customerService.updateCustomer(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/search")
    public CustomerResponseDto
    getCustomerByMobileNumber(
        @RequestParam String mobileNumber) {

        return customerService
            .getCustomerByMobileNumber(mobileNumber);
    }
}


