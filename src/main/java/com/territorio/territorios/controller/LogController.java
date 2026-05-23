package com.territorio.territorios.controller;

import com.territorio.territorios.dto.LogDTO;
import com.territorio.territorios.sevice.LogService;
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
@RequestMapping("/log")
@Tag(name = "Anotaciones", description = "Operaciones relacionadas con las anotaciones")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;
    @Operation( summary = "Crear locación", description = "Crea una nueva locación en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locación creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<LogDTO> create (@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Información de la anotación a crear",
            required = true
    ) @Valid @RequestBody LogDTO dto) {
        return ResponseEntity.ok(logService.create(dto));
    }
    @Operation( summary = "Buscar una anotación por id", description = "Obtiene una anotación específica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<LogDTO> getById(@Parameter(description = "ID del log") @PathVariable Integer id) {
        return ResponseEntity.ok(logService.getById(id));
    }
    @Operation( summary = "Listar todas las anotaciones", description = "Obtiene todas las anotaciones registradas en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anotaciones encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron anotaciones")
    })
    @GetMapping
    public ResponseEntity<List<LogDTO>> getAll() {
        return ResponseEntity.ok(logService.getAll());
    }
    @Operation( summary = "Listar las anotaciones de una locación", description = "Obtiene todas las anotaciones registradas en el sistema para una locación específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anotaciones encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron anotaciones")
    })
    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<LogDTO>> getAllByLocationId(Integer locationId) {
        return ResponseEntity.ok(logService.getAllByLocationId(locationId));
    }
    @Operation( summary = "Eliminar una anotación por id", description = "No elimina físicamente la anotación, solo marca la fecha de eliminación y no se lista en las consultas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anotación eliminada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID de la anotación") @PathVariable Integer id) {
        logService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
