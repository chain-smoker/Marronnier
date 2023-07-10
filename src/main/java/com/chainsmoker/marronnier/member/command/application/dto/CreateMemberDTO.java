package com.chainsmoker.marronnier.member.command.application.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Builder
public class CreateMemberDTO {
    private Long UID;
    private String name;
}
