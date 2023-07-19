package com.chainsmoker.marronnier.member.command.infra.service;

import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.member.command.domain.service.FindMemberRequest;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;

@InfraService
public class FindMemberRequestService implements FindMemberRequest {


    private final FindMemberService findMemberService;

    public FindMemberRequestService(FindMemberService findMemberService) {
        this.findMemberService = findMemberService;
    }

    @Override
    public FindMemberDTO getMemberById(long memberId) {
        return findMemberService.findById(memberId);
    }
}
