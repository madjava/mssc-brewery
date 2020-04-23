package com.eyetanfelix.msscbrewery.services;

import com.eyetanfelix.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
