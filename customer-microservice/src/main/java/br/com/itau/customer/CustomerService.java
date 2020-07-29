package br.com.itau.customer;

import br.com.itau.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
}