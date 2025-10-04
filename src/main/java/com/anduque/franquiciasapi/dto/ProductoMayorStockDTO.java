package com.anduque.franquiciasapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoMayorStockDTO {
    private Long productoId;
    private String productoNombre;
    private int stock;
    private Long sucursalId;
    private String sucursalNombre;

    public ProductoMayorStockDTO(Long idProducto, String nombreProducto, int stockProducto, Long idSucursal, String nombreSucursal) {
        this.productoId = idProducto;
        this.productoNombre = nombreProducto;
        this.stock = stockProducto;
        this.sucursalId = idSucursal;
        this.sucursalNombre = nombreSucursal;
    }
}
