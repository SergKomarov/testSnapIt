package com.example.demo.repository;

import com.example.demo.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID> {

    Optional<Sale> findById(UUID id);

}
