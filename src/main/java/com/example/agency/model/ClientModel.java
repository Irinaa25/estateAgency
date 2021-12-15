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
public class ClientModel {
    @JsonProperty(value = "full_name")
    private String fullName;

    @JsonProperty(value = "phone")
    private Long phone;
}


