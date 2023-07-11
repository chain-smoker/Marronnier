package com.chainsmoker.marronnier.member.command.application.service;

import com.chainsmoker.marronnier.member.command.application.dto.CreateMemberDTO;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.PlatformEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import com.chainsmoker.marronnier.member.command.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistMemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public RegistMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member create(CreateMemberDTO memberDTO) {
        Member memberEntity = Member.builder()
                .UID(memberDTO.getUID())
                .name(memberDTO.getName())
                .platform(PlatformEnum.KAKAO)
                .build();
        return memberRepository.save(memberEntity);
    }
}
