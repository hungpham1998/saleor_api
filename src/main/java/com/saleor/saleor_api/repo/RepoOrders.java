package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.Orders;
import com.saleor.saleor_api.table.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepoOrders extends JpaRepository<Orders,Long> {
    List<Orders> findAll();
    Optional<Orders> findById(Long id);
}
