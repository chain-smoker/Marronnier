package com.chainsmoker.marronnier.member.command.application.service;

import com.chainsmoker.marronnier.member.command.application.dto.UpdateMemberDTO;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import com.chainsmoker.marronnier.member.command.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UpdateMemberService {

    private final MemberRepository memberRepository;

    public UpdateMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public boolean updateMemberInformation(long memberId, UpdateMemberDTO updateMemberDTO) {
        Optional<Member> findMember = memberRepository.findById(memberId);
        if (findMember.isPresent()) {
            Member updateMember = findMember.get();
            if (updateMemberDTO.getAddress() != null) {
                updateMember.setAddress(updateMemberDTO.getAddress());
            }
            if (updateMemberDTO.getGender() != null) {
                updateMember.setGender(updateMemberDTO.getGender());
            }
            if (updateMemberDTO.getBirthDate() != null) {
                updateMember.setBirthDate(updateMemberDTO.getBirthDate());
            }
            if (updateMemberDTO.getJob() != null) {
                updateMember.setJob(updateMemberDTO.getJob());
            }
            if (updateMemberDTO.getProfileImage() != null) {
                updateMember.setProfileImage(updateMemberDTO.getProfileImage());
            }
            return true;
        } else {
            return false;
        }
    }
}
