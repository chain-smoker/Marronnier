package com.chainsmoker.marronnier.configuration.auth;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.EnumType.AdminRole;
import com.chainsmoker.marronnier.common.handler.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;

import java.io.IOException;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement().invalidSessionUrl("/login");
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/","/auth/**", "/css/**", "/images/**",
                "/js/**", "/h2-console/**","/login/**", "/admin/regist", "/admin/login", "/feed/feed","/admin/error").permitAll()
                .antMatchers("/home","/basket/**", "/profile/**", "/find/**", "/feed/**", "/apply/self").hasRole(Role.MEMBER.name())
                .antMatchers("/apply/**", "/report/**", "/admin/**").hasRole(AdminRole.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                    .authorizationEndpoint()
                        .and()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService)
                .and()
                .successHandler(oAuth2SuccessHandler)
                .failureHandler((request, response, exception) -> {
                    response.sendRedirect("/login");
                })
                ;

        http.formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/login")
                .usernameParameter("loginId")
                .passwordParameter("password")
                .successHandler((request, response, authentication) -> {
                    System.out.println("authentication : " + authentication.getName());
                    try {
                        response.sendRedirect("/admin/home");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .failureHandler((request, response, exception) -> {
                    request.setAttribute("errorMessage", exception.getMessage());
                    request.getRequestDispatcher("/admin/error").forward(request, response);
                })
                ;

        http
                .logout()//로그아웃 처리
                .logoutUrl("/logout")// 로그아웃 처리 URL
                .logoutSuccessUrl("/")//로그아웃 성공 후 이동페이지
        ;

        http
                .exceptionHandling()
                .authenticationEntryPoint((request, response, e) -> {  // 인증 실패 시 처리
                    System.out.println("인증 실패");
                    response.sendRedirect("/");
                })
                .accessDeniedHandler((request, response, e) -> {// 인가 실패 시 처리
                    System.out.println("인가 실패");
                    response.sendRedirect("/");
                })
        ;
        return http.build();
    }
}