package com.chainsmoker.marronnier.member.command.domain.service;

import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;

public interface FindMemberRequest {
    FindMemberDTO getMemberById(long memberId);
}
