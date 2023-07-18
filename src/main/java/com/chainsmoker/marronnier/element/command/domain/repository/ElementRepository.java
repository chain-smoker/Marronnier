package com.chainsmoker.marronnier.element.command.domain.repository;

import com.chainsmoker.marronnier.element.command.domain.aggregate.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {
}
