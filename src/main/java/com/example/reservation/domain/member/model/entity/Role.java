package com.example.reservation.domain.member.model.entity;

import static javax.persistence.EnumType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.reservation.domain.member.model.type.RoleName;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "role")
@NoArgsConstructor(access = PROTECTED)
public class Role {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "name")
	@Enumerated(value = STRING)
	private RoleName roleName;

	public Role(RoleName roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", roleName=" + roleName +
				'}';
	}
}
