package com.chainsmoker.marronnier.member.query.application.service;

import com.chainsmoker.marronnier.member.query.infra.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


}
