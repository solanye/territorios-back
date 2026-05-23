package com.territorio.territorios.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "DTO del territorio")
public class TerritoryDTO {
    @Schema(description = "Código interno asignado por el sistema")
    private Integer id;
    @Schema(description = "Código corto para identificar al territorio", example = "01 / 1A / A35")
    private String code;
    @Schema(description = "Fecha de creación del territorio")
    private LocalDate createdAt;
    @Schema(description = "Fecha de la última modificación del territorio")
    private LocalDate updatedAt;
    @Schema(description = "Fecha de la eliminación del territorio, si este campo no está vacío indica que el territorio está eliminado")
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
