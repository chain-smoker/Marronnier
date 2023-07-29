package com.chainsmoker.marronnier.apply.command.application.service;

import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.Apply;
import com.chainsmoker.marronnier.apply.command.domain.repository.ApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteApplyService {

    private final ApplyRepository applyRepository;

    @Autowired
    public DeleteApplyService(ApplyRepository applyRepository) {
        this.applyRepository = applyRepository;
    }

    public void delete(long id) {

        Apply apply = applyRepository.findById(id)
                // Optional 객체에서 값이 존재하면 해당 값을 반환, 없으면 RuntimeException을 발생
                .orElseThrow(RuntimeException::new);

        applyRepository.delete(apply);
    }
}
