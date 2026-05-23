package com.territorio.territorios.mapper;

import com.territorio.territorios.dto.LocationDTO;
import com.territorio.territorios.model.Location;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO toDto(Location location);
    @InheritInverseConfiguration
    Location toEntity(LocationDTO dto);
}
