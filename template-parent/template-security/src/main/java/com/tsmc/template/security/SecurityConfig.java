package com.tsmc.template.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final SysLoginSuccessHandler sysLoginSuccessHandler;
	
	private final SysLoginFailureHandler sysLoginFailureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    	
        http.csrf().disable().cors().and().authorizeRequests()
                .antMatchers("/auth/**","/api/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(sysLoginSuccessHandler)
                .failureHandler(sysLoginFailureHandler)
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

       http.sessionManagement()
                .invalidSessionUrl("/login")
                .maximumSessions(1)
                .expiredUrl("/login?expired")
                .sessionRegistry(sessionRegistry());
        
        return http.build();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
    
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/css/**", "/fonts/**", "/js/**");
    }

}
