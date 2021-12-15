package com.example.agency.service;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Estate;
import com.example.agency.model.EstateModel;
import org.springframework.data.domain.Page;

public interface EstateService {
    Estate getEstateById(Long id);

    Page<Estate> getEstate(PageDto pageDto);

    Estate addEstate(EstateModel estateModel);

    Estate updateEstate(Long id, EstateModel estateModel);

    void deleteById(Long id);
}
