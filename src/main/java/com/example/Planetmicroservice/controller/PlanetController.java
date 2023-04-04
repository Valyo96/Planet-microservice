package com.example.Planetmicroservice.controller;

import com.example.Planetmicroservice.dto.PlanetDTO;
import com.example.Planetmicroservice.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;

    @GetMapping("/planet/{id}")
    public ResponseEntity<PlanetDTO> getPlanetById(@PathVariable("id")Long id){
        return new ResponseEntity<>(planetService.getPlanetById(id), HttpStatus.OK);
    }

    @GetMapping("planets/{id}")
    public ResponseEntity<List<PlanetDTO>> getPlanetsByGalaxyId(@PathVariable("id")Long id){
        return new ResponseEntity<>(planetService.getPlanetDTOSByGalaxyId(id), HttpStatus.OK);
    }

    @PostMapping("/create-planet")
    public ResponseEntity createPlanet(@RequestBody PlanetDTO planetDTO){
        planetService.createPlanet(planetDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
