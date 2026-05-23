package com.territorio.territorios.repository;

import com.territorio.territorios.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByIdAndDeletedAtIsNull(Integer id);
    List<Location> findAllByDeletedAtIsNull();
    List<Location> findByTerritoryIdAndDeletedAtIsNull(Integer territoryId);
}
