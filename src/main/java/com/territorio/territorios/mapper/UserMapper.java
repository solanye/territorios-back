package com.territorio.territorios.mapper;

import com.territorio.territorios.dto.UserDTO;
import com.territorio.territorios.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

/*    @Mapping(source = "role.id", target = "roleId")*/

    UserDTO toDto(User user);

    /*@Mapping(source = "roleId", target = "role.id")*/
    @InheritInverseConfiguration
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO dto);
}