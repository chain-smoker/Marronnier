package com.chainsmoker.marronnier.member.query.application.service;

import com.chainsmoker.marronnier.member.query.infra.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberQueryApplicationService {

    MemberMapper memberMapper;

    @Autowired
    public MemberQueryApplicationService (MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


}
