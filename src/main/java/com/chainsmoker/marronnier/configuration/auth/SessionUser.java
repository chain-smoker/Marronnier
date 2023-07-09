package com.chainsmoker.marronnier.configuration.auth;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SessionUser {

    private String name;
    private Long uid;
    private Long id;
    public SessionUser(Member member) {
        this.name = member.getName();
        this.uid = member.getUID();
        this.id = member.getId();
    }
}
