package com.saleor.saleor_api.repo;

import com.saleor.saleor_api.table.ImportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RepoImportTicket extends JpaRepository<ImportTicket, Long> {

    Optional<ImportTicket> findByTitleContaining(String title);

    Optional<ImportTicket> findById(Long id);

    Optional<ImportTicket> findByTitleContainingOrPhoneContainingOrShipCodeContaining(String title, String phone, String code);

    @Query("select a from ImportTicket a where a.createdDate BETWEEN :creationFromDateTime AND :creationToDateTime")
    List<ImportTicket> findAllServiceShop(Date creationFromDateTime , Date creationToDateTime);
}
