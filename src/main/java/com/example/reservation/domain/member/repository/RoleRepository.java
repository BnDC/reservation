package com.example.reservation.domain.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.domain.member.model.entity.Role;
import com.example.reservation.domain.member.model.type.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByRoleName(RoleName groupName);
}
