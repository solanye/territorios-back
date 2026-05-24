package com.territorio.territorios.mapper;

import com.territorio.territorios.dto.LocationDTO;
import com.territorio.territorios.model.Location;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    @Mapping(source = "territory.code", target = "territoryCode")
    LocationDTO toDto(Location location);
    @InheritInverseConfiguration
    Location toEntity(LocationDTO dto);
}
