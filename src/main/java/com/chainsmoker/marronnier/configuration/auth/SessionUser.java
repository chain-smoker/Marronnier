package com.chainsmoker.marronnier.configuration.auth;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import lombok.Getter;

@Getter
public class SessionUser {
    private final long id;
    private final String name;
    private final Role role;

    private SessionUser(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
    }

    public static Builder builder(long id, String name,Role role) {
        return new Builder(id, name, role);
    }

    public static class Builder {
        private final long id;
        private final String name;
        private final Role role;

        private Builder(long id, String name, Role role) {
            this.id = id;
            this.name = name;
            this.role = role;
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

