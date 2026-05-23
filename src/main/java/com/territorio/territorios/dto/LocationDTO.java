package com.territorio.territorios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "DTO de la locación")
public class LocationDTO {
    @Schema(description = "Código interno asignado por el sistema")
    private Integer id;
    @Schema(description = "Código corto para identificar a la locacion", example = "01 / 1A / A35")
    @NotBlank
    @Size(max = 4)
    @Pattern(
            regexp = "^\\S+$",
            message = "El código no puede contener espacios"
    )
    private String code;
    @Schema(description = "Código del territorio")
    private Integer territoryId;
    @Schema(description = "Fecha de creación de la locación")
    private LocalDate createdAt;
    @Schema(description = "Fecha de la última modificación de la locación")
    private LocalDate updatedAt;
    @Schema(description = "Fecha de la eliminación de la locación, si este campo no está vacío indica que la locación está eliminada")
    private LocalDate deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(Integer territoryId) {
        this.territoryId = territoryId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }
}
