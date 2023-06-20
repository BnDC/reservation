package com.example.reservation.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.domain.member.model.entity.MemberRole;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long> {
}
