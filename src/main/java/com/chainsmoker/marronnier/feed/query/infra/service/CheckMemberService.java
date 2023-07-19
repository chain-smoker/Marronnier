package com.chainsmoker.marronnier.feed.query.infra.service;

import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckMemberService implements com.chainsmoker.marronnier.feed.query.domain.service.CheckMemberService {
    private final FindMemberService findMemberService;
    @Autowired
    public CheckMemberService(FindMemberService findMemberService) {
        this.findMemberService = findMemberService;
    }

    public String findMemberNameByMemberId(long memberId){
        return findMemberService.findById(memberId).getName();

    }

    public FindMemberDTO findById(long memberId){
        return findMemberService.findById(memberId);
    }

}
