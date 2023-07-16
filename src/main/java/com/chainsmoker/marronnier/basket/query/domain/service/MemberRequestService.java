package com.chainsmoker.marronnier.basket.query.domain.service;

import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;

public interface MemberRequestService {
    FindMemberDTO getMemberById(long memberId);
}
