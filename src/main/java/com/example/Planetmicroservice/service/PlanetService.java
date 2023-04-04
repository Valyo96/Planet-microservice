package com.example.Planetmicroservice.service;

import com.example.Planetmicroservice.dto.PlanetDTO;
import com.example.Planetmicroservice.model.Planet;
import com.example.Planetmicroservice.repository.PlanetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlanetService {

    private final PlanetRepository planetRepository;

    private final PlanetBuilder planetBuilder;

    public PlanetDTO getPlanetById(Long id){
        return planetBuilder.buildPlanetDTO(planetRepository.findById(id).orElseThrow(()-> new RuntimeException("No such planet with "+id+"id")));
    }

    public List<PlanetDTO> getPlanetDTOSByGalaxyId(Long galaxyId){
        return planetRepository.getPlanetsByGalaxyId(galaxyId).stream()
                .map(planetBuilder::buildPlanetDTO)
                .collect(Collectors.toList());
    }

    public void createPlanet(PlanetDTO planetDTO){
        Planet planet = planetBuilder.buildPlanet(planetDTO);
        planetRepository.save(planet);
        log.info("You successfully created the {} planet" , planet.getName());
    }
}
