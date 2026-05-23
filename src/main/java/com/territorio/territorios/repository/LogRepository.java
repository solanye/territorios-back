package com.territorio.territorios.repository;

import com.territorio.territorios.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LogRepository  extends JpaRepository<Log, Integer> {
    Optional<Log> findByIdAndDeletedAtIsNull(Integer id);
    List<Log> findAllByDeletedAtIsNull();
    List<Log> findByLocationIdAndDeletedAtIsNull(Integer locationId);

}
