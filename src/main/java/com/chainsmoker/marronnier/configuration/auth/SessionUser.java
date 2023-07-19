package com.chainsmoker.marronnier.configuration.auth;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
public class SessionUser implements OAuth2User {
    private final long id;
    private final String name;
    private final Role role;
    private final String profileImage;

    private SessionUser(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
        this.profileImage = builder.profileImg;
    }


    public static Builder builder(long id, String name, Role role, String profileImg) {
        return new Builder(id, name, role, profileImg);
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attr = new HashMap<>();
        attr.put("id", this.id);
        attr.put("name", this.name);
        attr.put("role", this.role);
        return attr;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role.getKey()));
    }

    public String getNameAttributeKey() {
        return "id";
    }

    public static class Builder {
        private final long id;
        private final String name;
        private final Role role;
        private final String profileImg;

        private Builder(long id, String name, Role role, String profileImg) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.profileImg = profileImg;
        }

        /**
         * 위 생성자에서 만약 입력 값 중 옵셔널 값일 경우 Setter를 통해 값을 초기화
         * 위 경우 Builder 클래스의 옵셔널 필드는 final 키워드 사용 불가
         * 이러한 경우 Builder 패턴을 사용하는 의미가 크게 낮아짐.
         */

        public SessionUser build() {
            return new SessionUser(this);
        }
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

