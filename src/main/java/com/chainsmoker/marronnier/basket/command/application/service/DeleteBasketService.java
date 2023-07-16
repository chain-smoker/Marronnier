package com.chainsmoker.marronnier.basket.command.application.service;

import com.chainsmoker.marronnier.basket.command.application.dto.DeleteBasketDTO;
import com.chainsmoker.marronnier.basket.command.domain.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteBasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public DeleteBasketService (BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void delete(DeleteBasketDTO deleteBasketDTO) {
        basketRepository.deleteById(deleteBasketDTO.getBasketId());
    }
}
