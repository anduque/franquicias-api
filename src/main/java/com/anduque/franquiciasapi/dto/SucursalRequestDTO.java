package com.anduque.franquiciasapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SucursalRequestDTO {

    @NotBlank(message = "El nombre de la sucursal es de caracter obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotNull(message = "La sucursal debe asociarse a una franquicia")
    private Long franquiciaId;
}
