package com.anduque.franquiciasapi.service;

import com.anduque.franquiciasapi.dto.ApiResponse;
import com.anduque.franquiciasapi.dto.FranquiciaRequestDTO;
import com.anduque.franquiciasapi.dto.FranquiciaUpdateDTO;
import com.anduque.franquiciasapi.dto.ProductoMayorStockDTO;
import com.anduque.franquiciasapi.model.Franquicia;
import com.anduque.franquiciasapi.model.Producto;
import com.anduque.franquiciasapi.model.Sucursal;
import com.anduque.franquiciasapi.repository.FranquiciaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public FranquiciaService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    //Obtener franquicias
    public List<Franquicia> findAll() {
        return franquiciaRepository.findAll();
    }

    //Crear franquicia
    public ApiResponse<Franquicia> createFranquicia(FranquiciaRequestDTO franquiciaRequestDTO) {
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(franquiciaRequestDTO.getNombre());
        Franquicia savedFranquicia = franquiciaRepository.save(franquicia);

        return new ApiResponse<>("Franquicia creada con éxito", null, savedFranquicia);
    }

    //Buscar franquicia por ID
    public Optional<Franquicia> findById(Long id) {
        return franquiciaRepository.findById(id);
    }

    //Buscar los productos con mayor stock por cada sucursal de una franquicia
    public List<ProductoMayorStockDTO> getMayorStock(Long id) {
        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        List<ProductoMayorStockDTO> result = new ArrayList<>();

        for(Sucursal sucursal: franquicia.getSucursales()){
            Producto mayorStock = null;
            for(Producto p: sucursal.getProductos()){
                if (mayorStock==null || p.getStock()>mayorStock.getStock()){
                    mayorStock = p;
                }
            }

            if(mayorStock!=null){
                ProductoMayorStockDTO mayorStockDTO = new ProductoMayorStockDTO(
                        mayorStock.getId(),
                        mayorStock.getNombre(),
                        mayorStock.getStock(),
                        sucursal.getId(),
                        sucursal.getNombre()
                );
                result.add(mayorStockDTO);
            }
        }
        return result;
    }

    //Actualizar nombre de franquicia
    public ApiResponse<Franquicia> updateNombreFranquiciaById(Long id, FranquiciaUpdateDTO franquiciaUpdateDTO) {
        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        franquicia.setNombre(franquiciaUpdateDTO.getNuevoNombre());
        Franquicia updateFranquicia = franquiciaRepository.save(franquicia);

        return new ApiResponse<>("Franquicia actualizada", null, updateFranquicia);
    }
}
