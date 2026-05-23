package com.territorio.territorios.controller;

import com.territorio.territorios.dto.TerritoryDTO;
import com.territorio.territorios.sevice.TerritoryService;
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
@RequestMapping("/territory")
@Tag(name = "Territorios", description = "Operaciones relacionadas con los territorios")
@RequiredArgsConstructor
public class TerritoryController {
    private final TerritoryService territoryService;
    @Operation( summary = "Crear territorio", description = "Crea un nuevo territorio en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Territorio creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<TerritoryDTO> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Información del territorio a crear",
            required = true
    ) @Valid @RequestBody TerritoryDTO dto){
        return ResponseEntity.ok(territoryService.create(dto));
    }
    @Operation( summary = "Buscar un territorio por id", description = "Obtiene un territorio específico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<TerritoryDTO> getById(@Parameter(description = "ID del territorio") @PathVariable Integer id) {
        return ResponseEntity.ok(territoryService.getById(id));
    }
    @Operation( summary = "Listar todos los territorios", description = "Obtiene todas los territorios registrados en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Territorios encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron territorios")
    })
    @GetMapping
    public ResponseEntity<List<TerritoryDTO>> getAll() {
        return ResponseEntity.ok(territoryService.getAll());
    }
    @Operation( summary = "Eliminar un territorio por id", description = "No elimina físicamente el territorio, solo marca la fecha de eliminación y no se lista en las consultas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Territorio eliminado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID del territorio") @PathVariable Integer id) {
        territoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
