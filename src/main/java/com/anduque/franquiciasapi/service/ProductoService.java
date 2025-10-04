package com.anduque.franquiciasapi.service;

import com.anduque.franquiciasapi.model.Producto;
import com.anduque.franquiciasapi.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Obtener productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    //Buscar producto por ID
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    //Guardar o actualizar producto
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    //Eliminar producto
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
