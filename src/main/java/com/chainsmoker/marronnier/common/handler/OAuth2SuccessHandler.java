package com.chainsmoker.marronnier.common.handler;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        SessionUser oAuth2User = (SessionUser) authentication.getPrincipal();
        String targetUrl;
        if (oAuth2User != null) {
            targetUrl = UriComponentsBuilder.fromUriString("/home")
                    .build().toUriString();
        } else {
            targetUrl = UriComponentsBuilder.fromUriString("/")
                    .build().toUriString();
        }
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
