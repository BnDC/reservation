package com.example.reservation.domain.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservation.domain.member.model.dto.BusinessSignupRequest;
import com.example.reservation.domain.member.model.dto.MemberLoginRequest;
import com.example.reservation.domain.member.model.dto.MemberSignupRequest;
import com.example.reservation.domain.member.model.dto.MemberSignupResponse;
import com.example.reservation.domain.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {
	private final MemberService memberService;

	@PostMapping("/members/signup")
	public ResponseEntity<MemberSignupResponse> memberSignup(
			@Validated @RequestBody MemberSignupRequest memberSignupRequest
	) {
		Long memberId = memberService.memberSignup(memberSignupRequest);
		return new ResponseEntity<>(new MemberSignupResponse(memberId), HttpStatus.CREATED);
	}

	@PostMapping("/business/signup")
	public ResponseEntity<Void> businessSignup(
			@Validated @RequestBody BusinessSignupRequest businessSignupRequest
	) {
		memberService.businessSignup(businessSignupRequest);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/login")
	public ResponseEntity<Void> login(
			HttpServletRequest request,
			@Validated @RequestBody MemberLoginRequest memberLoginRequest
	) {
		UserDetails userDetails = memberService.login(memberLoginRequest);

		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities()
				);

		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(authenticationToken);

		HttpSession session = request.getSession();
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);

		log.info("[memberController.login] session = {}", session.getId());
		log.info("[memberController.login] session attributes = {}", session.getAttributeNames());
		return ResponseEntity.ok().build();
	}
}
