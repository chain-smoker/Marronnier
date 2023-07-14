package com.chainsmoker.marronnier.elementbyrecipe.query.domain.service;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;

public interface ElementRequestService {
    public FindElementDTO findByElementId(Long elementId);
}
