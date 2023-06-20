package com.example.reservation.domain.member.model.entity;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "business_information")
@NoArgsConstructor(access = PROTECTED)
public class BusinessInformation {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "business_license", length = 10)
	private String businessLicense;

	@ManyToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	public BusinessInformation(String businessLicense, Member member) {
		this.businessLicense = businessLicense;
		this.member = member;
	}
}
