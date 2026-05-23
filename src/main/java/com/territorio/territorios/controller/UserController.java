package com.territorio.territorios.controller;

import com.territorio.territorios.dto.UserDTO;
import com.territorio.territorios.sevice.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @Operation( summary = "Crear usuario", description = "Crea un nuevo usuario en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<UserDTO> create ( @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Información del usuario a crear",
            required = true
    ) @Valid @RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.create(dto));
    }
    @Operation( summary = "Buscar un usuario por id", description = "Obtiene un usuario específico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@Parameter(description = "ID del usuario") @PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
    @Operation( summary = "Listar todos los usuarios", description = "Obtiene todos los usuarios registrados en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron usuarios")
    })
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Operation( summary = "Eliminar un usuario por id", description = "No elimina físicamente el usuario, solo marca la fecha de eliminación y no se lista en las consultas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID del usuario") @PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}