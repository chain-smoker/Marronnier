package com.chainsmoker.marronnier.cocktail.command.domain.repository;

import com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element,Long> {
}
