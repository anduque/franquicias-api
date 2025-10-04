package com.anduque.franquiciasapi.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoUpdateStockDTO {
    @Min(value = 0, message = "El stock debe ser mayor o igual a 0")
    private int stock;
}
