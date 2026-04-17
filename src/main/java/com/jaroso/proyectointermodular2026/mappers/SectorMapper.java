package com.jaroso.proyectointermodular2026.mappers;


import com.jaroso.proyectointermodular2026.dtos.SectorCreateDto;
import com.jaroso.proyectointermodular2026.dtos.SectorDto;
import com.jaroso.proyectointermodular2026.entities.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SectorMapper {
    SectorDto toDto(Sector sector);

    @Mapping(target = "id", ignore = true)
    Sector toEntity(SectorCreateDto sectorCreateDto);
}
