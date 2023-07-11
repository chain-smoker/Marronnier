package com.chainsmoker.marronnier.basket.query.infra.service;

import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;
import com.chainsmoker.marronnier.member.query.domain.entity.QueryMember;
import org.springframework.beans.factory.annotation.Autowired;

@InfraService
public class MemberRequestService implements com.chainsmoker.marronnier.basket.query.domain.service.MemberRequestService {

    private final FindMemberService findMemberService;

    @Autowired
    public MemberRequestService(FindMemberService findMemberService) {
        this.findMemberService = findMemberService;
    }

    @Override
    public QueryMember getMemberById(long memberId) {

        return findMemberService.findById(memberId);
    }
}
