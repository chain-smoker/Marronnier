package com.chainsmoker.marronnier.apply.query.application.service;

import com.chainsmoker.marronnier.apply.query.application.dto.QueryApplyDTO;
import com.chainsmoker.marronnier.apply.query.domain.entity.QueryApply;
import com.chainsmoker.marronnier.apply.query.infra.repository.QueryApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QueryApplyService {

    private final QueryApplyRepository applyRepository;

    @Autowired
    public QueryApplyService(QueryApplyRepository applyRepository) {
            this.applyRepository = applyRepository;
    }

    public Page<QueryApplyDTO> getApplys(int pageNo, int pageSize, String sortBy) {

        // 페이지 번호는 0부터 시작
        int pageNumber = pageNo -1;
        // 정렬 기준과 방향(desc)
        Sort sort = Sort.by(sortBy).descending();
        // 페이징 정보가 들어있는 객체
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<QueryApply> applyPage = applyRepository.findAll(pageable);

        // Entity -> DTO 반환
        return applyPage.map(this::toDTO);
    }

    // Entity -> DTO 변환 로직
    private QueryApplyDTO toDTO(QueryApply queryApply) {
        QueryApplyDTO dto = new QueryApplyDTO();
        dto.setId(queryApply.getId());
        dto.setTitle(queryApply.getTitle());
        dto.setContent(queryApply.getContent());
        dto.setCategory(queryApply.getCategory());
        dto.setApproval(queryApply.isApproval());
        dto.setCreatedDate(queryApply.getCreatedDate());
        dto.setModifiedDate(queryApply.getModifiedDate());
        dto.setRequesterId(queryApply.getRequesterId());
        return dto;
    }
}
