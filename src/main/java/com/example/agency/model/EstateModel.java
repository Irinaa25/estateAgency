package com.example.agency.model;

import com.example.agency.entity.Estate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

public class EstateModel {
        @JsonProperty(value = "name")
        private String name;

        @JsonProperty(value = "estate_type")
        private String estate_type;

        @JsonProperty(value = "price")
        private int price;

        @JsonProperty(value = "year_construction")
        private int year_construction;

        @JsonProperty(value = "area")
        private int area;

        @JsonProperty(value = "clientId")
        private Long clientId;
}

