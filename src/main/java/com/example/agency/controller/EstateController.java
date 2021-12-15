package com.example.agency.controller;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Estate;
import com.example.agency.model.EstateModel;
import com.example.agency.service.EstateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/estate")
public class EstateController {
    private final EstateService agencyService;

    @GetMapping("/{id}")
    public ResponseEntity<Estate> getEstateById(@PathVariable Long id) {
        return new ResponseEntity<Estate>(agencyService.getEstateById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Estate>> getEstate(PageDto pageDto) {
        return new ResponseEntity<>(agencyService.getEstate(pageDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estate> addEstate(@RequestBody EstateModel estateModel) {
        return new ResponseEntity<>(agencyService.addEstate(estateModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estate> updateEstate(@PathVariable Long id, @RequestBody EstateModel estateModel) {
        return new ResponseEntity<>(agencyService.updateEstate(id, estateModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {agencyService.deleteById(id);
    }

}



