package com.example.reservation.domain.member.service;

import static com.example.reservation.common.util.AuthenticationUtil.*;
import static com.example.reservation.domain.member.model.type.RoleName.*;
import static java.util.stream.Collectors.*;

import javax.persistence.EntityNotFoundException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reservation.common.util.PasswordEncodeUtil;
import com.example.reservation.domain.member.model.BusinessInformationMapper;
import com.example.reservation.domain.member.model.CustomUserDetails;
import com.example.reservation.domain.member.model.MemberMapper;
import com.example.reservation.domain.member.model.dto.BusinessSignupRequest;
import com.example.reservation.domain.member.model.dto.MemberLoginRequest;
import com.example.reservation.domain.member.model.dto.MemberSignupRequest;
import com.example.reservation.domain.member.model.entity.BusinessInformation;
import com.example.reservation.domain.member.model.entity.Member;
import com.example.reservation.domain.member.model.entity.MemberRole;
import com.example.reservation.domain.member.model.entity.Role;
import com.example.reservation.domain.member.model.type.RoleName;
import com.example.reservation.domain.member.repository.BusinessInformationRepository;
import com.example.reservation.domain.member.repository.MemberRepository;
import com.example.reservation.domain.member.repository.MemberRoleRepository;
import com.example.reservation.domain.member.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
	private final MemberRepository memberRepository;
	private final BusinessInformationRepository businessInformationRepository;
	private final MemberRoleRepository memberRoleRepository;
	private final RoleRepository roleRepository;

	@Transactional
	public Long memberSignup(MemberSignupRequest memberSignupRequest) {
		Role role = getRole(USER);

		Member member = memberRepository.save(MemberMapper.toMember(memberSignupRequest));
		memberRoleRepository.save(new MemberRole(member, role));
		return member.getId();
	}

	@Transactional
	public Long businessSignup(BusinessSignupRequest businessSignupRequest) {
		Member member = memberRepository.findByEmailWithRole(getUsername())
				.orElseThrow(() -> new EntityNotFoundException("멤버를 찾을 수 없습니다."));

		BusinessInformation businessInformation = businessInformationRepository.save(
				BusinessInformationMapper.toBusinessInformation(businessSignupRequest, member)
		);

		if (businessSignupRequest.getRoleName().isNotBusinessRole()) {
			throw new IllegalArgumentException("잘못된 roleName 입니다");
		}

		Role role = getRole(businessSignupRequest.getRoleName());
		memberRoleRepository.save(new MemberRole(member, role));
		return businessInformation.getId();
	}

	@Transactional
	public UserDetails login(MemberLoginRequest memberLoginRequest) {
		UserDetails userDetails = loadUserByUsername(memberLoginRequest.getEmail());
		if (PasswordEncodeUtil.isNotValidPassword(
				memberLoginRequest.getPassword(), userDetails.getPassword()
		)) {
			throw new BadCredentialsException("잘못된 인증 정보 입니다");
		}
		return userDetails;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return memberRepository.findByEmailWithRole(username)
				.map(member ->
						new CustomUserDetails(
								member.getId(),
								User.builder()
										.username(member.getEmail())
										.password(member.getPassword())
										.authorities(member.getMemberRoles()
												.stream()
												.map(memberRole -> new SimpleGrantedAuthority(
														memberRole.getRole()
																.getRoleName()
																.name()))
												.collect(toList()))
										.build()))
				.orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다"));
	}

	private Role getRole(RoleName roleName) {
		return roleRepository.findByRoleName(roleName)
				.orElseThrow(EntityNotFoundException::new);
	}
}
