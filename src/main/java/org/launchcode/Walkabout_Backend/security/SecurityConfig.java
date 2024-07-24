package org.launchcode.Walkabout_Backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(registry -> {

            //role based authorization: allows EVERYONE to access these pages
            registry.requestMatchers("/home").permitAll();

            //role based authorization: allows only ADMIN to access these pages
            registry.requestMatchers("/admin/**").hasRole("ADMIN");

            //role based authorization: allows USERS to access these pages
            registry.requestMatchers("/user/**").hasRole("USER");

            registry.anyRequest().authenticated();
        })
        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
        .build();
    }

    //create in-line users
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
                .username("gc")
//              **don't want to do plain text password so it can't be reverse engineered-- encode instead
                .password("$2a$12$LD6yaJlsKj/097K9wgCPpeXIT1G0ZazymvduoiSr4v8NS8TbS9gtO")
                .roles("USER")
                .build();
        UserDetails adminUser = User.builder()
                .username("admin")
                .password("$2a$12$rqa1hroPau1OvOvn97kqZuuJQnmAEp40nvHSEm2pOklqMeLxF4dlG")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        //google online bcrypt encoder (e.g. https://bcrypt-generator.com/  ) to encrypt a password
    }

}
