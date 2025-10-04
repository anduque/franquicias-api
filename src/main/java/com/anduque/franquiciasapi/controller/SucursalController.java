package com.anduque.franquiciasapi.controller;

import com.anduque.franquiciasapi.model.Sucursal;
import com.anduque.franquiciasapi.service.SucursalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
