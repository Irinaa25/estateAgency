package com.example.agency.service;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Deal;
import com.example.agency.model.DealModel;
import org.springframework.data.domain.Page;

public interface DealService {
    Deal getDealById(Long id);

    Page<Deal> getDeal(PageDto pageDto);

    Deal addDeal(DealModel dealModel);

    Deal updateDeal(Long id, DealModel dealModel);

    void deleteById(Long id);
}
