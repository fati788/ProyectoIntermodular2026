package com.jaroso.proyectointermodular2026.repositories;

import com.jaroso.proyectointermodular2026.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor , Long> {
}
