package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.Units;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUnit extends JpaRepository<Units, Long> {
}
