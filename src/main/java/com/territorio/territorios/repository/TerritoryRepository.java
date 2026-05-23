package com.territorio.territorios.repository;

import com.territorio.territorios.model.Territory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TerritoryRepository  extends JpaRepository<Territory, Integer> {
    Optional<Territory> findByIdAndDeletedAtIsNull(Integer id);
    List<Territory> findAllByDeletedAtIsNull();
}
