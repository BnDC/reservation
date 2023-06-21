package com.example.reservation.domain.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reservation.domain.member.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	@Query(value = "select m from Member m join fetch m.memberRoles where m.email = :email ")
	Optional<Member> findByEmailWithRole(String email);
}
