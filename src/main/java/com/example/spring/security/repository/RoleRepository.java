package com.example.spring.security.repository;

import com.example.spring.security.entities.Role;
import com.example.spring.security.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(RoleName name);
}
