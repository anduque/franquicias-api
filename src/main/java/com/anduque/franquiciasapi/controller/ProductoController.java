package com.anduque.franquiciasapi.controller;

import com.anduque.franquiciasapi.dto.ApiResponse;
import com.anduque.franquiciasapi.dto.ProductoRequestDTO;
import com.anduque.franquiciasapi.dto.ProductoUpdateDTO;
import com.anduque.franquiciasapi.dto.ProductoUpdateStockDTO;
import com.anduque.franquiciasapi.model.Producto;
import com.anduque.franquiciasapi.service.ProductoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ApiResponse<Producto>> createProducto(@Valid @RequestBody ProductoRequestDTO productoRequestDTO) {
        ApiResponse<Producto> producto = productoService.createProducto(productoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<String>> deleteProducto(@PathVariable("id") Long id){
        ApiResponse<String> producto = productoService.deleteProductoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(producto);
    }

    @PatchMapping("{id}/stock")
    public ResponseEntity<ApiResponse<Producto>> updateStock(@PathVariable("id") Long id, @Valid @RequestBody ProductoUpdateStockDTO productoUpdateStockDTO){
        ApiResponse<Producto> response = productoService.updateProductoById(id, productoUpdateStockDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("{id}/nombre")
    public ResponseEntity<ApiResponse<Producto>> updateNombreProducto(@PathVariable("id") Long id, @Valid @RequestBody ProductoUpdateDTO productoUpdateDTO){
        ApiResponse<Producto> response = productoService.updateNombreProductoById(id, productoUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
