package com.anduque.franquiciasapi.service;

import com.anduque.franquiciasapi.model.Sucursal;
import com.anduque.franquiciasapi.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    //Obtener sucursales
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    //Buscar sucursal por ID
    public Optional<Sucursal> findById(Long id) {
        return sucursalRepository.findById(id);
    }

    //Eliminar sucursal
    public void deleteById(Long id) {
        sucursalRepository.deleteById(id);
    }
}
