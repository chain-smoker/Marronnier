package com.chainsmoker.marronnier.configuration.auth;

import com.chainsmoker.marronnier.common.handler.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2SuccessHandler successHandler;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/","/auth/**", "/css/**", "/images/**",
                "/js/**", "/h2-console/**","/login/**", "/admin/regist", "/admin/login").permitAll()
                .antMatchers("/basket/**", "/profile/**", "/find/**", "/feed/**").hasRole(Role.MEMBER.name())
                .anyRequest().authenticated()
//			    .antMatchers("/**").authenticated() // 인가된 사용자만 접근 가능하도록 설정
//			    .antMatchers("게시물등").hasRole(Role.USER.name()) // 특정 ROLE을 가진 사용자만 접근 가능하도록 설정
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .successHandler(successHandler)
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

        return http.build();
    }
}