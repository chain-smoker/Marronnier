package com.chainsmoker.marronnier.configuration.auth;

import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.chainsmoker.marronnier.member.command.application.dto.CreateMemberDTO;
import com.chainsmoker.marronnier.member.command.application.service.RegistMemberService;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;
import com.chainsmoker.marronnier.member.query.domain.entity.QueryMember;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomOAuth2UserService  extends DefaultOAuth2UserService {
    private final RegistMemberService registMemberService;
    private final FindMemberService findMemberService;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> service = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = service.loadUser(userRequest); // Oath2 정보를 가져옴

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 소셜 정보 가져옴

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        SessionUser sessionUser = saveOrUpdate(attributes);
        httpSession.setAttribute("user", sessionUser);

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("member")),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    private SessionUser saveOrUpdate(OAuthAttributes attributes) {
        QueryMember member = findMemberService.findByUid(attributes.getUid());
        SessionUser sessionUser = null;
        if (member == null) {
            Member newMember = registMemberService.create(
                    CreateMemberDTO.builder()
                            .name(attributes.getName())
                            .UID(attributes.getUid())
                            .build());
            //sessionUser = SessionUser.builder().addId(newMember.getId()).name(newMember.getName()).build();
            sessionUser = SessionUser.builder(newMember.getId(), newMember.getName()).build();
        } else {
            //sessionUser = SessionUser.builder().id(member.getId()).name(member.getName()).build();
            sessionUser = SessionUser.builder(member.getId(), member.getName()).build();
        }
        return sessionUser;
    }
}
