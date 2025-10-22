package com.khan.ecommerce.customer;

import com.khan.ecommerce.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    // Create new customer
    public String createCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    // Update existing customer
    public void updateCustomer(CustomerRequest request) {
        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer :: No customer found with the provided ID:: %s", request.id())
                ));
        mergeCustomer(customer, request); // fixed method name
        repository.save(customer);
    }

    // Merge fields correctly
    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());  // correct
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname());    // correct
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());          // correct
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    // Get all customers
    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    // Check if customer exists
    public Boolean existsById(String customerId) {
        return repository.findById(customerId)
                .isPresent();
    }

    // Get customer by ID
    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("No customer found with the provided ID:: %s", customerId)
                ));
    }

    // Delete customer
    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
