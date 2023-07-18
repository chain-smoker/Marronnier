package com.chainsmoker.marronnier.configuration.auth;

import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.chainsmoker.marronnier.member.command.application.dto.CreateMemberDTO;
import com.chainsmoker.marronnier.member.command.application.dto.UpdateMemberDTO;
import com.chainsmoker.marronnier.member.command.application.service.RegistMemberService;
import com.chainsmoker.marronnier.member.command.application.service.UpdateMemberService;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService  extends DefaultOAuth2UserService {
    private final RegistMemberService registMemberService;
    private final FindMemberService findMemberService;
    private final UpdateMemberService updateMemberService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> service = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = service.loadUser(userRequest); // Oath2 정보를 가져옴

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 소셜 정보 가져옴

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        SessionUser sessionUser = saveOrUpdate(attributes);

        return sessionUser;
    }

    private SessionUser saveOrUpdate(OAuthAttributes attributes) {
        FindMemberDTO member = findMemberService.findByUid(attributes.getUid());
        SessionUser sessionUser = null;
        if (member == null) {
            CreateMemberDTO createMemberDTO = new CreateMemberDTO(attributes.getUid(), attributes.getName(), Role.MEMBER, attributes.getProfileImage());
            Member newMember = registMemberService.create(createMemberDTO);
            //sessionUser = SessionUser.builder().addId(newMember.getId()).name(newMember.getName()).build();
            sessionUser = SessionUser.builder(newMember.getId(), newMember.getName(), newMember.getRole()).build();
        } else {
            UpdateMemberDTO updateMemberDTO = new UpdateMemberDTO(attributes.getProfileImage());
            boolean updateMemberResult = updateMemberService.updateMemberInformation(member.getId(), updateMemberDTO);
            //sessionUser = SessionUser.builder().id(member.getId()).name(member.getName()).build();
            sessionUser = SessionUser.builder(member.getId(), member.getName(), member.getRole()).build();
        }
        return sessionUser;
    }
}
