package com.chainsmoker.marronnier.element.query.infra.repository;

import com.chainsmoker.marronnier.element.query.domain.entity.QueryElement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchElementMapper {
    List<QueryElement> searchElement(String searchWord);
}
