package com.cinemaapp.backend.security;

import com.cinemaapp.backend.service.UserService;
import com.cinemaapp.backend.service.impl.CredentialsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {

    private final CredentialsServiceImpl credentialsServiceImpl;

    private final JwtConfig jwtConfig;

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserService userService;

    @Autowired
    public SecurityCredentialsConfig(JwtConfig jwtConfig, CredentialsServiceImpl credentialsServiceImpl, BCryptPasswordEncoder passwordEncoder, UserService userService) {
        this.jwtConfig = jwtConfig;
        this.credentialsServiceImpl = credentialsServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, userService))
                .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .antMatchers("/api/user/**").permitAll()
                .antMatchers("/api/loggedUser/**").hasRole("USER")// any other requests must be authenticated
                .antMatchers("/api/employee/**", "/api/loggedEmployee/**").hasRole("EMPLOYEE")// any other requests must be authenticated
                .antMatchers("/api/**").hasRole("ADMIN");// any other requests must be authenticated
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(credentialsServiceImpl).passwordEncoder(passwordEncoder);
    }
}