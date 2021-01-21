package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.Customer;
import com.saleor.saleor_api.table.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepoCustomer extends JpaRepository<Customer,Long> {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
}
