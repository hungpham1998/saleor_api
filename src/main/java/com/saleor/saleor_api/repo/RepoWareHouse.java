package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoWareHouse extends JpaRepository<WareHouse, Long> {
    Optional<WareHouse> findByPhoneContainingOrTitleContaining(String phone, String title);
    Optional<WareHouse> findByPhoneContaining(String phone);
    Optional<WareHouse> findByTitleContaining(String title);
}
