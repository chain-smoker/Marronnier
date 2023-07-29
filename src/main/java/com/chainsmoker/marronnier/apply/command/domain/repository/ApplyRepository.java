package com.chainsmoker.marronnier.apply.command.domain.repository;

import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

}
