package com.chainsmoker.marronnier.member.command.application.dto;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import lombok.*;

@Getter
public class CreateMemberDTO {
    private Long UID;
    private String name;
    private Role role;

    public CreateMemberDTO(Long UID, String name, Role role) {
        this.UID = UID;
        this.name = name;
        this.role = role;
    }
}
