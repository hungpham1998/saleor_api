package com.saleor.saleor_api.repo;


import com.saleor.saleor_api.table.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoSupplier extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByTitleContaining(String title);

    Optional<Supplier> findByPhoneContaining(String phone);

    Optional<Supplier> findByPhoneContainingOrTitleContaining(String phone, String title);

    void delete(long id);

}
