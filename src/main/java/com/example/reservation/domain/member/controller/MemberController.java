package com.example.reservation.domain.member.controller;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservation.domain.member.model.dto.BusinessSignupRequest;
import com.example.reservation.domain.member.model.dto.BusinessSignupResponse;
import com.example.reservation.domain.member.model.dto.MemberLoginRequest;
import com.example.reservation.domain.member.model.dto.MemberSignupRequest;
import com.example.reservation.domain.member.model.dto.MemberSignupResponse;
import com.example.reservation.domain.member.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "회원 컨트롤러")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {
	private final MemberService memberService;

	@Operation(summary = "회원 생성", description = "회원 생성을 위한 api")
	@ApiResponse(code = 201, message = "created")
	@PostMapping("/members/signup")
	public ResponseEntity<MemberSignupResponse> memberSignup(
			@Validated @RequestBody MemberSignupRequest memberSignupRequest
	) {
		Long memberId = memberService.memberSignup(memberSignupRequest);
		return new ResponseEntity<>(new MemberSignupResponse(memberId), CREATED);
	}

	@Operation(summary = "사업자 등록", description = "사업자 등록을 위한 api")
	@ApiResponse(code = 201, message = "created")
	@PostMapping("/business/signup")
	public ResponseEntity<BusinessSignupResponse> businessSignup(
			HttpServletRequest request,
			@Validated @RequestBody BusinessSignupRequest businessSignupRequest
	) {
		Long businessInformationId = memberService.businessSignup(businessSignupRequest);
		HttpSession session = request.getSession(true);
		session.invalidate();
		return new ResponseEntity<>(new BusinessSignupResponse(businessInformationId), OK);
	}

	@Operation(summary = "회원 로그인", description = "회원 로그인을 위한 api")
	@ApiResponse(code = 200, message = "ok")
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
		session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, context);

		log.info("[memberController.login] session = {}", session.getId());
		log.info("[memberController.login] session attributes = {}", session.getAttributeNames());
		return ResponseEntity.ok().build();
	}
}
