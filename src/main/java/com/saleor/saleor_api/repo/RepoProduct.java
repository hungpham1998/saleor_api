package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RepoProduct extends JpaRepository<Product,Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);

    List<Product> findBy();
}
