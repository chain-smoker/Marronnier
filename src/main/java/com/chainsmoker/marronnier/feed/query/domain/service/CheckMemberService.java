package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;

public interface CheckMemberService {
    String findMemberNameByMemberId(long memberId);
    FindMemberDTO findById(long memberId);
}
