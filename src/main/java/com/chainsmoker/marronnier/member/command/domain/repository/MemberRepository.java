package com.chainsmoker.marronnier.member.command.domain.repository;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}