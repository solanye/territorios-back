package com.territorio.territorios.mapper;

import com.territorio.territorios.dto.LogDTO;
import com.territorio.territorios.model.Log;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LogMapper {
    @Mapping(source = "user.names", target = "userName")
    LogDTO toDto(Log log);
    @InheritInverseConfiguration
    @Mapping(target = "location", ignore = true)
    Log toEntity(LogDTO dto);
}
