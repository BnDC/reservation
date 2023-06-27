package com.example.reservation.config;

import static org.springframework.http.HttpMethod.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JdbcIndexedSessionRepository jdbcIndexedSessionRepository;

	@Bean
	SessionRegistry springSessionBackedSessionRegistry(
			JdbcIndexedSessionRepository jdbcIndexedSessionRepository
	) {
		return new SpringSessionBackedSessionRegistry<>(jdbcIndexedSessionRepository);
	}

	@Bean
	PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebSecurityCustomizer configure() {
		return (web) -> web.ignoring().mvcMatchers(
				"/webjars/**",
				"/swagger-ui.html",
				"/swagger-resources/**",
				"/v2/api-docs",
				"/swagger/**"
		);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.authorizeRequests()
				.antMatchers("/api/**/business/**").hasAuthority("USER")
				.antMatchers(POST, "/api/**/theaters/**").hasAuthority("THEATER_BUSINESS")
				.antMatchers(POST, "/api/**/movies/**", "/api/**/schedules/**").hasAuthority("PERFORMANCE_BUSINESS")
				.and()
				.csrf().disable()
				.headers().disable()
				.formLogin().disable()
				.httpBasic().disable()
				.rememberMe().disable()
				.logout().disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				.sessionFixation().migrateSession()
				.maximumSessions(1)
				.sessionRegistry(springSessionBackedSessionRegistry(jdbcIndexedSessionRepository))
				.and()
				.and()
				.requestCache().requestCache(new NullRequestCache())
				.and()
				.build();
	}
}
