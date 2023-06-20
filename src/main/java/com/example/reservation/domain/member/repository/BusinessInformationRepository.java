package com.example.reservation.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.domain.member.model.entity.BusinessInformation;

public interface BusinessInformationRepository extends JpaRepository<BusinessInformation, Long> {
}
