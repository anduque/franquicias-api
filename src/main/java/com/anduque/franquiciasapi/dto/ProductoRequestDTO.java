package com.anduque.franquiciasapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequestDTO {

    @NotBlank(message = "El nombre del producto es de caracter obligatorio")
    @Size(min = 2, max = 100, message = "El nombre del producto debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El sotck del producto es de caracter obligatorio")
    @Min(value = 0, message = "El stock debe ser igual o mayor a 0")
    private Integer stock;

    @NotNull(message = "El producto debe asociarse con una sucursal")
    private Long sucursalId;
}
