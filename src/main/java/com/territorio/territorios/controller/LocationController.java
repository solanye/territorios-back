package com.territorio.territorios.controller;

import com.territorio.territorios.dto.LocationDTO;
import com.territorio.territorios.sevice.LocationService;
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
@RequestMapping("/location")
@Tag(name = "Locaciones", description = "Operaciones relacionadas con las locaciones")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    @Operation( summary = "Crear locación", description = "Crea una nueva locación en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locación creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<LocationDTO> create ( @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Información de la locación a crear",
            required = true
    ) @Valid @RequestBody LocationDTO dto) {
        return ResponseEntity.ok(locationService.create(dto));
    }
    @Operation( summary = "Buscar una locación por id", description = "Obtiene una locación específica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getById(@Parameter(description = "ID de la locación") @PathVariable Integer id) {
        return ResponseEntity.ok(locationService.getById(id));
    }
    @Operation( summary = "Listar todas las locaciones", description = "Obtiene todas las locaciones registradas en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locaciones encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron locaciones")
    })
    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }
    @Operation( summary = "Listar las locaciones de un territorio", description = "Obtiene todas las locaciones registradas en el sistema para un territorio específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locaciones encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron locaciones")
    })
    @GetMapping("/territory/{territoryId}")
    public ResponseEntity<List<LocationDTO>> getAllByTerritoryId(Integer territoryId) {
        return ResponseEntity.ok(locationService.getAllByTerritoryId(territoryId));
    }
    @Operation( summary = "Eliminar una locación por id", description = "No elimina físicamente la locación, solo marca la fecha de eliminación y no se lista en las consultas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locación eliminada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID de la locación") @PathVariable Integer id) {
        locationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
