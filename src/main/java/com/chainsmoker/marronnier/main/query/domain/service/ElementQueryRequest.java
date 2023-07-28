package com.chainsmoker.marronnier.main.query.domain.service;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;

import java.util.List;

public interface ElementQueryRequest {

    public List<FindElementDTO> searchElement(String searchWord);
}
