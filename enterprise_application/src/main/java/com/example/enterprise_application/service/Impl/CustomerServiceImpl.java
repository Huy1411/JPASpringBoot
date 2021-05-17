package com.example.enterprise_application.service.Impl;

import com.example.enterprise_application.jpa.Customer;
import com.example.enterprise_application.repository.CustomerRepository;
import com.example.enterprise_application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listCustomers(){
        try{
            List<Customer> list = customerRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getCustomerById(int customer_id){
        try{
            Customer customer = customerRepository.findById(customer_id).get();
            return customer;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomerByEmail(String email){
        try{
            List<Customer> list = customerRepository.findByEmail(email);
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        try{
            customerRepository.save(customer);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try{
            customerRepository.save(customer);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int customer_id) {
        try{
            Customer customer = customerRepository.findById(customer_id).get();
            customerRepository.save(customer);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Customer> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.customerRepository.findPaginateCustomers(pageable);
    }

}
