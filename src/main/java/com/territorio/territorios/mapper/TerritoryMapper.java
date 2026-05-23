package com.territorio.territorios.mapper;

import com.territorio.territorios.dto.TerritoryDTO;
import com.territorio.territorios.model.Territory;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TerritoryMapper {
    TerritoryDTO toDto(Territory territory);
    @InheritInverseConfiguration
    Territory toEntity(TerritoryDTO dto);
}
