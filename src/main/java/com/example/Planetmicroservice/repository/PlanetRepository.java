package com.example.Planetmicroservice.repository;

import com.example.Planetmicroservice.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet , Long> {
    @Query("SELECT p FROM Planet p WHERE p.galaxyId = :id")
    List<Planet> getPlanetsByGalaxyId(@Param("id")Long id);
}
