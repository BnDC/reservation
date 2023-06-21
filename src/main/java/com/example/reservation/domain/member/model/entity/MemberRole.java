package com.example.reservation.domain.member.model.entity;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.reservation.domain.member.model.entity.Member;
import com.example.reservation.domain.member.model.entity.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "member_role")
@NoArgsConstructor(access = PROTECTED)
public class MemberRole {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@ManyToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(optional = false, fetch = LAZY)
	@JoinColumn(name = "role_id")
	private Role role;

	public MemberRole(Member member, Role role) {
		this.member = member;
		this.role = role;
	}

	@Override
	public String toString() {
		return "MemberRole{" +
				"id=" + id +
				", member=" + "{" + "id" + member.getId() + "" + member.getName() + "}" +
				", role=" + role +
				'}';
	}
}
