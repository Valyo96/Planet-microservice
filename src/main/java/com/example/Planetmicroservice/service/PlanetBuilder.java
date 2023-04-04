package com.example.Planetmicroservice.service;

import com.example.Planetmicroservice.dto.PlanetDTO;
import com.example.Planetmicroservice.model.Planet;
import org.springframework.stereotype.Service;

@Service
public class PlanetBuilder {

    public Planet buildPlanet(PlanetDTO planetDTO){
        return Planet.builder()
                .name(planetDTO.getName())
                .inhabitable(planetDTO.isInhabitable())
                .moon(planetDTO.getMoon())
                .size(planetDTO.getSize())
                .galaxyId(planetDTO.getGalaxyId())
                .build();
    }

    public PlanetDTO buildPlanetDTO(Planet planet){
        return PlanetDTO.builder()
                .name(planet.getName())
                .inhabitable(planet.isInhabitable())
                .moon(planet.getMoon())
                .size(planet.getSize())
                .build();
    }
}
