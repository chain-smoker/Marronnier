package com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.EnumType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AdminRole {

    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
}
