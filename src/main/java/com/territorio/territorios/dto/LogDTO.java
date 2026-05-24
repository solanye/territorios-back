package com.territorio.territorios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Schema(description = "DTO de la anotación de un usuario en un territorio")
public class LogDTO {
    @Schema(description = "Código interno asignado por el sistema")
    private Integer id;
    @Schema(description = "Anotación", example = "La persona se ha mudado de lugar")
    @NotBlank
    private String text;
    @Schema(description = "Código de la anotación a la cual se le asigna el log")
    private Integer locationId;
    @Schema(description = "Código del usuario que hizo la anotación")
    private Integer userId;
    @Schema(description = "Nombre del usuario que hizo la anotación", accessMode = Schema.AccessMode.READ_ONLY)
    private String userName;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
