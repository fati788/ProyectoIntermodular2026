package com.jaroso.proyectointermodular2026.controllers;


import com.jaroso.proyectointermodular2026.dtos.SensorCreateDto;
import com.jaroso.proyectointermodular2026.dtos.SensorDto;
import com.jaroso.proyectointermodular2026.dtos.SensorUpdateDto;
import com.jaroso.proyectointermodular2026.entities.Sector;
import com.jaroso.proyectointermodular2026.entities.Sensor;
import com.jaroso.proyectointermodular2026.mappers.SensorMapper;
import com.jaroso.proyectointermodular2026.repositories.SectorRepository;
import com.jaroso.proyectointermodular2026.repositories.SensorRepository;
import com.jaroso.proyectointermodular2026.servecies.MqttPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private SensorMapper mapper;

    @Autowired
    private MqttPublisher mqttPublisher;

    Logger logger = Logger.getLogger(LecturaController.class.getName());

    @GetMapping("/sensors")
    public ResponseEntity<List<SensorDto>> getAll(){
        return ResponseEntity.ok(sensorRepository.findAll().stream().map(mapper::toDto).toList());
    }

    @GetMapping("/sensors/{id}")
    public ResponseEntity<SensorDto> getById(@PathVariable Long id){
        logger.info("Leyendo sensor: " + id);
        Optional<SensorDto> sensor = sensorRepository.findById(id).map(mapper::toDto);
        return sensor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/sensors")
    public ResponseEntity<SensorDto> createSensor(@RequestBody SensorCreateDto sensor){
        Sensor sensorEntity = mapper.toEntity(sensor);

        Sector sector = sectorRepository.findById(sensor.sectorId()).orElseThrow(() -> new IllegalArgumentException("Sector no encontrado"));
        sensorEntity.setSector(sector);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(mapper.toDto(sensorRepository.save(sensorEntity)));
    }

    @PutMapping("/sensors/{id}")
    public ResponseEntity<SensorDto> updateSensor(@PathVariable Long id, @RequestBody SensorUpdateDto sensorUpdateDto){
        logger.info("Actualizando sensor: " + sensorUpdateDto);
        Optional<Sensor> sensor = sensorRepository.findById(id);
        if (sensor.isPresent()){
            sensor.get().setEstado(sensorUpdateDto.estado());

            // publica un mensaje MQTT al topic del actuador (ej: actuadores/1/comando con payload ON o OFF)
            String payload = String.format("{\"estado\": \"%s\"}", sensorUpdateDto.estado());
            mqttPublisher.publish(sensor.get().getTopicMQTTAct(), payload);

            return ResponseEntity.ok(mapper.toDto(sensorRepository.save(sensor.get())));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/sensors/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id){
        sensorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
