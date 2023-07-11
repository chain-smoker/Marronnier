package com.chainsmoker.marronnier.member.command.application.dto;

import lombok.*;

@Getter
@Builder
public class CreateMemberDTO {
    private Long UID;
    private String name;
}
