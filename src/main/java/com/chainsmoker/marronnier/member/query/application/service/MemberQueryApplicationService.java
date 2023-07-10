package com.chainsmoker.marronnier.member.query.application.service;

import com.chainsmoker.marronnier.member.query.domain.entity.QueryMember;
import com.chainsmoker.marronnier.member.query.infra.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberQueryApplicationService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberQueryApplicationService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public QueryMember findById(long id) {
        QueryMember member = memberMapper.findById(id);
        return member;
    }

    public QueryMember findByUid(long uid) {
        QueryMember member = memberMapper.findByUID(uid);
        return member;
    }


}
