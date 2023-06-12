package com.itjeon.oauth.api.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.itjeon.oauth.api.config.prop.CorsProperties;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final CorsProperties corsProperties;

    @Bean
	protected SecurityFilterChain fileterChain(HttpSecurity http) throws Exception {
		http
			.cors( (cors) -> cors
					.configurationSource(corsConfigurationSource())
			)
			.authorizeHttpRequests((authz) -> authz
					.anyRequest().authenticated()
			)
		;
		
		return http.build();
	}
    
    /*
     * Cors 설정
     * */
     @Bean
     public UrlBasedCorsConfigurationSource corsConfigurationSource() {
         UrlBasedCorsConfigurationSource corsConfigSource = new UrlBasedCorsConfigurationSource();
 
         CorsConfiguration corsConfig = new CorsConfiguration();
         corsConfig.setAllowedHeaders(Arrays.asList(corsProperties.getAllowedHeaders().split(",")));
         corsConfig.setAllowedMethods(Arrays.asList(corsProperties.getAllowedMethods().split(",")));
         corsConfig.setAllowedOrigins(Arrays.asList(corsProperties.getAllowedOrigins().split(",")));
         corsConfig.setAllowCredentials(true);
         corsConfig.setMaxAge(corsConfig.getMaxAge());
 
         corsConfigSource.registerCorsConfiguration("/**", corsConfig);
         return corsConfigSource;
     }
}
