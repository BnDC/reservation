package com.example.reservation.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeUtil {
	private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public static String toEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public static boolean isNotValidPassword(String inputPassword, String password) {
		return !passwordEncoder.matches(inputPassword, password);
	}
}
