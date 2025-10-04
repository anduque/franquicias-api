package com.anduque.franquiciasapi.service;

import com.anduque.franquiciasapi.dto.ApiResponse;
import com.anduque.franquiciasapi.dto.SucursalRequestDTO;
import com.anduque.franquiciasapi.model.Franquicia;
import com.anduque.franquiciasapi.model.Sucursal;
import com.anduque.franquiciasapi.repository.FranquiciaRepository;
import com.anduque.franquiciasapi.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;
    private final FranquiciaRepository franquiciaRepository;

    public SucursalService(SucursalRepository sucursalRepository, FranquiciaRepository franquiciaRepository) {
        this.sucursalRepository = sucursalRepository;
        this.franquiciaRepository = franquiciaRepository;
    }

    //Obtener sucursales
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    //Crear sucursal
    public ApiResponse<Sucursal> createSucursal(SucursalRequestDTO sucursalRequestDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalRequestDTO.getNombre());
        Franquicia franquicia = franquiciaRepository.findById(sucursalRequestDTO.getFranquiciaId())
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        sucursal.setFranquicia(franquicia);
        Sucursal savedSucursal = sucursalRepository.save(sucursal);

        return new ApiResponse<>("Sucursal creada con éxito",  null, savedSucursal);
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
