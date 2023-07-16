package com.chainsmoker.marronnier.basket.query.infra.service;

import com.chainsmoker.marronnier.basket.query.domain.service.MemberRequest;
import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;
import org.springframework.beans.factory.annotation.Autowired;

@InfraService
public class MemberRequestService implements MemberRequest {

    private final FindMemberService findMemberService;

    @Autowired
    public MemberRequestService(FindMemberService findMemberService) {
        this.findMemberService = findMemberService;
    }

    @Override
    public FindMemberDTO getMemberById(long memberId) {

        return findMemberService.findById(memberId);
    }
}
