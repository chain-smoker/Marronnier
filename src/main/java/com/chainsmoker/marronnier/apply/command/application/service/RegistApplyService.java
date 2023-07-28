package com.chainsmoker.marronnier.apply.command.application.service;

import com.chainsmoker.marronnier.apply.command.application.dto.CreateApplyDTO;
import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.Apply;
import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.EnumType.CategoryEnum;
import com.chainsmoker.marronnier.apply.command.domain.repository.ApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistApplyService {

    private final ApplyRepository applyRepository;

    @Autowired
    public RegistApplyService(ApplyRepository applyRepository) {
        this.applyRepository = applyRepository;
    }

    public void create(CreateApplyDTO createApplyDTO) {

        // DTO -> Entity 변환 작업
        String title = createApplyDTO.getTitle();
        String content = createApplyDTO.getContent();
        CategoryEnum category = CategoryEnum.valueOf(createApplyDTO.getCategory());
        boolean isApproval = createApplyDTO.isApproval();
        long requesterId = createApplyDTO.getRequesterId();

        Apply apply = new Apply(title, content, category, isApproval, requesterId);

        applyRepository.save(apply);
    }
}
