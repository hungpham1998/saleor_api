package com.saleor.saleor_api.repo;
import com.saleor.saleor_api.table.ImportTicketDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepoImportTickEtDetail extends JpaRepository<ImportTicketDetail, Long> {
    Optional<ImportTicketDetail> findById(Long id);

}
