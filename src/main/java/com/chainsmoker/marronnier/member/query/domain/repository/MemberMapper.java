package com.chainsmoker.marronnier.member.query.domain.repository;

import com.chainsmoker.marronnier.member.query.domain.entity.QueryMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<QueryMember> findAll();

   QueryMember findById(long id);

    QueryMember findByUID(long uid);
}
