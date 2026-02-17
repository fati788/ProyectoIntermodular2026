package com.jaroso.proyectointermodular2026.mappers;


import com.jaroso.proyectointermodular2026.dtos.LecturaCreateDto;
import com.jaroso.proyectointermodular2026.dtos.LecturaDto;
import com.jaroso.proyectointermodular2026.entities.Lectura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LecturaMapper {
    @Mapping(target = "sensorId", source = "sensor.id")
    LecturaDto toDto(Lectura lectura);

    Lectura toEntity(LecturaCreateDto lecturaCreateDto);
}