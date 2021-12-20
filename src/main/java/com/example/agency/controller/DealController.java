package com.example.agency.controller;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Deal;
import com.example.agency.model.DealModel;
import com.example.agency.model.EstateModel;
import com.example.agency.service.DealService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/deal")
public class DealController {
    private final DealService agencyService;

    @GetMapping("/{id}")
    public ResponseEntity<Deal> getDealById(@PathVariable Long id) {
        return new ResponseEntity<Deal>(agencyService.getDealById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Deal>> getDeal(PageDto pageDto) {
        return new ResponseEntity<>(agencyService.getDeal(pageDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Deal> addDeal(@RequestBody DealModel dealModel) {
        return new ResponseEntity<>(agencyService.addDeal(dealModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deal> updateDeal(@PathVariable Long id, @RequestBody DealModel dealModel) {
        return new ResponseEntity<>(agencyService.updateDeal(id, dealModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {agencyService.deleteById(id);
    }

}
