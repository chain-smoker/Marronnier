package com.chainsmoker.marronnier.configuration.auth;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class SessionUser {
    private Long id;
    private String name;
}
