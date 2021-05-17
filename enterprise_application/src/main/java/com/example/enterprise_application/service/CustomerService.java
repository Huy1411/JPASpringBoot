package com.example.enterprise_application.service;

import com.example.enterprise_application.jpa.Country;
import com.example.enterprise_application.jpa.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    List<Customer> listCustomers();
    List<Customer> getCustomerByEmail(String email);
    Customer getCustomerById(int customer_id);
    boolean saveCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int customer_id);
    Page<Customer> findPaginated(int pageNo, int pageSize);

}
