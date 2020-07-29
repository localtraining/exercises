package br.com.itau.customer;

import br.com.itau.customer.model.Customer;
import br.com.itau.customer.model.dto.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper mapper;

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer create(CustomerRequest customerRequest) {
        Customer customer = mapper.toCustomer(customerRequest);

        return customerRepository.save(customer);
    }
}