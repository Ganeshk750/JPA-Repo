package com.ganesh.apis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.apis.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
     Optional<Role> findByName(String name);
}
