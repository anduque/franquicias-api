package com.anduque.franquiciasapi.controller;

import com.anduque.franquiciasapi.model.Franquicia;
import com.anduque.franquiciasapi.service.FranquiciaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
