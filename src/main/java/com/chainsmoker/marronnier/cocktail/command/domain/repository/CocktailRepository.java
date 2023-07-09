package com.chainsmoker.marronnier.cocktail.command.domain.repository;

import com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<Cocktail,Long> {
}

