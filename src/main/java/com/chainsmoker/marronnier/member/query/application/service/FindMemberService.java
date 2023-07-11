package com.chainsmoker.marronnier.member.query.application.service;

import com.chainsmoker.marronnier.member.query.domain.entity.QueryMember;
import com.chainsmoker.marronnier.member.query.infra.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindMemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public FindMemberService(MemberMapper memberMapper) {
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
