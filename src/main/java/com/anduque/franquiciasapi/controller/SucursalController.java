package com.anduque.franquiciasapi.controller;

import com.anduque.franquiciasapi.dto.ApiResponse;
import com.anduque.franquiciasapi.dto.SucursalRequestDTO;
import com.anduque.franquiciasapi.dto.SucursalUpdateDTO;
import com.anduque.franquiciasapi.model.Sucursal;
import com.anduque.franquiciasapi.service.SucursalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping
    public List<Sucursal> getSucursales(){
        return sucursalService.findAll();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Sucursal>> createSucursal(@Valid @RequestBody SucursalRequestDTO sucursalRequestDTO){
        ApiResponse<Sucursal> sucursal = sucursalService.createSucursal(sucursalRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursal);
    }

    @PatchMapping("{id}/nombre")
    public ResponseEntity<ApiResponse<Sucursal>> updateNombreSucursal(@PathVariable Long id, @Valid @RequestBody SucursalUpdateDTO sucursalUpdateDTO){
        ApiResponse<Sucursal> response = sucursalService.updateNombreSucursalById(id, sucursalUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
