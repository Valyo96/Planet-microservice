package com.example.Planetmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetDTO {

    private String name;

    private boolean inhabitable;

    private String moon;

    private int size;

    private Long galaxyId;
}
