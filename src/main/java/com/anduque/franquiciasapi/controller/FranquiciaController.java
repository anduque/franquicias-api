package com.anduque.franquiciasapi.controller;

import com.anduque.franquiciasapi.dto.*;
import com.anduque.franquiciasapi.model.Franquicia;
import com.anduque.franquiciasapi.service.FranquiciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franquicia")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @GetMapping
    public List<Franquicia> getFranquicias() {
        return franquiciaService.findAll();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Franquicia>> createFranquicia(@Valid @RequestBody FranquiciaRequestDTO franquiciaRequestDTO) {
        ApiResponse<Franquicia> franquicia = franquiciaService.createFranquicia(franquiciaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(franquicia);
    }

    @GetMapping("{id}/productos-mayor-stock")
    public ResponseEntity<ApiResponse<List<ProductoMayorStockDTO>>> getMayorStock(@PathVariable("id") Long id) {
        List<ProductoMayorStockDTO> productoMayorStockDTOList = franquiciaService.getMayorStock(id);
        return ResponseEntity.ok(new ApiResponse<>("Productos con mayor stock por sucursal", null, productoMayorStockDTOList));
    }

    @PatchMapping("{id}/nombre")
    public ResponseEntity<ApiResponse<Franquicia>> updateNombreFranquicia(@PathVariable("id") Long id, @Valid @RequestBody FranquiciaUpdateDTO franquiciaUpdateDTO) {
        ApiResponse<Franquicia> response = franquiciaService.updateNombreFranquiciaById(id, franquiciaUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
