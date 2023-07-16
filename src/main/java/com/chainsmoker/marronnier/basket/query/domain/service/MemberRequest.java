package com.chainsmoker.marronnier.basket.query.domain.service;

import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;

public interface MemberRequest {
    FindMemberDTO getMemberById(long memberId);
}
