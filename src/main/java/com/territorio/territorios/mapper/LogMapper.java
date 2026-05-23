package com.territorio.territorios.mapper;

import com.territorio.territorios.dto.LogDTO;
import com.territorio.territorios.model.Log;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogMapper {
    LogDTO toDto(Log log);
    @InheritInverseConfiguration
    Log toEntity(LogDTO dto);
}
