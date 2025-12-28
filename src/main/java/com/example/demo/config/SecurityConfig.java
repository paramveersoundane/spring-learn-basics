package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/auth/register").permitAll().anyRequest().authenticated())
				.csrf(csrf -> csrf.disable()).httpBasic(Customizer.withDefaults());

		return httpSecurity.build();

	}

}
/*
 * ===================== SPRING SECURITY AUTH FLOW =====================
 *
 * 1. Request comes in (e.g., /donateBook).
 *    - SecurityConfig requires authentication for all endpoints except /auth/register.
 *    - So Spring Security intercepts the request.
 *
 * 2. HTTP Basic Authentication is triggered.
 *    - Username and password are extracted from the Authorization header.
 *
 * 3. UserDetailsService (UserAuthService) is called.
 *    - loadUserByUsername(username) fetches UserAuthEntity from DB.
 *    - Entity must implement UserDetails and return getUsername() + getPassword().
 *
 * 4. Password verification happens internally in Spring Security:
 *    - DaoAuthenticationProvider calls passwordEncoder.matches(rawPassword, storedHashedPassword).
 *    - rawPassword = from request
 *    - storedHashedPassword = from DB (BCrypt encoded during registration)
 *
 * 5. Outcome:
 *    - If match → authentication succeeds → controller method executes.
 *    - If mismatch → authentication fails → Spring Security returns 401 Unauthorized.
 *
 * NOTE:
 * - Password comparison is NOT done manually in your code.
 * - It is handled automatically by Spring Security using the configured PasswordEncoder.
 */
