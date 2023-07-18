package com.chainsmoker.marronnier.member.command.application.dto;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import lombok.*;

@Getter
public class CreateMemberDTO {
    private Long UID;
    private String name;
    private Role role;
    private String profileImage;

    public CreateMemberDTO(Long UID, String name, Role role, String profileImage) {
        this.UID = UID;
        this.name = name;
        this.role = role;
        this.profileImage = profileImage;
    }
}
