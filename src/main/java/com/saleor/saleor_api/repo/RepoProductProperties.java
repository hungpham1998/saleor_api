package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.ProductProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RepoProductProperties extends JpaRepository<ProductProperties,Long> {
    List<ProductProperties>findAll();
    Optional<ProductProperties>findById(Long id);
}
