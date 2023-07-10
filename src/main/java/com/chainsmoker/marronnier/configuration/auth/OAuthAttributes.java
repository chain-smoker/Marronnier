package com.chainsmoker.marronnier.configuration.auth;



import java.util.Map;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.PlatformEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String name;
    private final Long uid;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, Long uid, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.uid = uid;
    }

    public static OAuthAttributes of(String socialName, String userNameAttributeName, Map<String, Object> attributes){
        // 카카오
        if("kakao".equals(socialName)){
            return ofKakao("id", attributes);
        }

        return null;
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Long uid = (Long) attributes.get("id");
        Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

        return OAuthAttributes.builder()
                .name((String) kakaoProfile.get("nickname"))
                .uid(uid)
                .nameAttributeKey(userNameAttributeName)
                .attributes(attributes)
                .build();
    }
}
