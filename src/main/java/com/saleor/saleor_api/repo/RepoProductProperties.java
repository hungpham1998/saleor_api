package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.Product;
import com.saleor.saleor_api.table.ProductProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Repository
public interface RepoProductProperties extends JpaRepository<ProductProperties,Long> {
//    List<ProductProperties>findAllBy(Pageable pageable);
    Optional<ProductProperties>findById(Long id);
    List<ProductProperties>findAllByProduct(Product product);
}
