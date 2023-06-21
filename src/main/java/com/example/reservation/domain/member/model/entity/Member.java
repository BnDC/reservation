package com.example.reservation.domain.member.model.entity;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.reservation.common.util.PasswordEncodeUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = PROTECTED)
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "name", length = 20)
	private String name;

	@Column(name = "email", length = 20, unique = true)
	private String email;

	@Column(name = "password", length = 60)
	private String password;

	@OneToMany(mappedBy = "member")
	private List<MemberRole> memberRoles = new ArrayList<>();

	public Member(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = PasswordEncodeUtil.toEncodedPassword(password);
	}

	@Override
	public String toString() {
		return "Member{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", memberRoles=" + memberRoles +
				'}';
	}
}
