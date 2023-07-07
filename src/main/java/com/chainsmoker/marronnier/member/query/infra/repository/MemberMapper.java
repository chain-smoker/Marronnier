package com.chainsmoker.marronnier.member.query.infra.repository;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> getMemberList();
}
