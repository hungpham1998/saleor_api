package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.ProductCatogories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoProductCatogories extends JpaRepository<ProductCatogories, Long> {

    Optional<ProductCatogories> findById(Long id);

    Optional<ProductCatogories> findByTitleContainingOrCodeContaining(String title, String code);

}
