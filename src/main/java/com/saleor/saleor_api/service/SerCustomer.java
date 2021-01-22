package com.saleor.saleor_api.service;

import com.saleor.saleor_api.repo.RepoCustomer;
import com.saleor.saleor_api.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerCustomer {
    @Autowired
    RepoCustomer repoCustomer;

    public List<Customer> GetAll()
    {
        return  repoCustomer.findAll();
    }
    public Optional<Customer> GetByID(Long id)
    {
        return  repoCustomer.findById(id);
    }
    public Customer InsertData(Customer orders) { return repoCustomer.save(orders); }

    public Customer UpdateData(Customer orders) { return repoCustomer.save(orders); }

    public void Delete(Long id) { repoCustomer.deleteById(id); }
}