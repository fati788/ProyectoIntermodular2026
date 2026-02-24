package com.jaroso.proyectointermodular2026.controllers;

import com.jaroso.proyectointermodular2026.dtos.SensorCreatetoDto;
import com.jaroso.proyectointermodular2026.dtos.SensorDto;
import com.jaroso.proyectointermodular2026.entities.Sensor;
import com.jaroso.proyectointermodular2026.mappers.SensorMapper;
import com.jaroso.proyectointermodular2026.repositories.SensorRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    @Autowired
    private SensorRepository repository;
    @Autowired
    private SensorMapper mapper;

    /**
     * Metodo para obtener todos los sensores
     * @return
     */
    @GetMapping
    public ResponseEntity<List<SensorDto>> getAllSensores(){
        return ResponseEntity.ok(repository.findAll()
                .stream().map(mapper::toDto).toList());
    }

    @PostMapping
    public ResponseEntity<SensorDto> createSensor(@RequestBody SensorCreatetoDto sensor){
        Sensor sensor1 = mapper.toEntity(sensor);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(repository.save(sensor1)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SensorDto> getSensorById(@PathVariable Long id){
        Optional<SensorDto> sensor = repository.findById(id).map(mapper::toDto);
        return sensor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    //FALTA PUT el Update


}
