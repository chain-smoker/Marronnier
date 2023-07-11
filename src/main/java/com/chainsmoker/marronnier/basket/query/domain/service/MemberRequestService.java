package com.chainsmoker.marronnier.basket.query.domain.service;

import com.chainsmoker.marronnier.member.query.domain.entity.QueryMember;

public interface MemberRequestService {
    QueryMember getMemberById(long memberId);
}
