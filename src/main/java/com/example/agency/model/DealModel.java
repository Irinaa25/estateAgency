package com.example.agency.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class DealModel {
    @JsonProperty(value = "realtor")
    private String realtor;

    @JsonProperty(value = "clientId")
    private Long clientId;
}
