package com.anduque.franquiciasapi.controller;

import com.anduque.franquiciasapi.model.Producto;
import com.anduque.franquiciasapi.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getProductos(){
        return productoService.findAll();
    }
}
