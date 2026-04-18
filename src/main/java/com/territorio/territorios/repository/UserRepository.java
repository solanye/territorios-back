package com.territorio.territorios.repository;

import com.territorio.territorios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserAndDeletedAtIsNull(String user);

    List<User> findAllByDeletedAtIsNull();
}
