package com.chainsmoker.marronnier.member.query.application.service;

import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.member.query.domain.entity.QueryMember;
import com.chainsmoker.marronnier.member.query.domain.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindMemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public FindMemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public FindMemberDTO findById(long id) {
        QueryMember member = memberMapper.findById(id);
        return FindMemberDTO.builder(
                member.getId(),
                member.getName(),
                member.getAddress(),
                member.getGender(),
                member.getBirthDate(),
                member.getRole()
        ).build();
    }

    public FindMemberDTO findByUid(long uid) {
        QueryMember member = memberMapper.findByUID(uid);
        return FindMemberDTO.builder(
                member.getId(),
                member.getName(),
                member.getAddress(),
                member.getGender(),
                member.getBirthDate(),
                member.getRole()
        ).build();
    }


}
