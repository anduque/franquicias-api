package com.anduque.franquiciasapi.service;

import com.anduque.franquiciasapi.dto.ApiResponse;
import com.anduque.franquiciasapi.dto.ProductoRequestDTO;
import com.anduque.franquiciasapi.dto.ProductoUpdateStockDTO;
import com.anduque.franquiciasapi.model.Producto;
import com.anduque.franquiciasapi.model.Sucursal;
import com.anduque.franquiciasapi.repository.ProductoRepository;
import com.anduque.franquiciasapi.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;

    public ProductoService(ProductoRepository productoRepository, SucursalRepository sucursalRepository) {
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
    }

    //Obtener productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    //Crear producto
    public ApiResponse<Producto> createProducto(ProductoRequestDTO productoRequestDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoRequestDTO.getNombre());
        producto.setStock(productoRequestDTO.getStock());
        Sucursal sucursal = sucursalRepository.findById(productoRequestDTO.getSucursalId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        producto.setSucursal(sucursal);
        Producto savedProducto = productoRepository.save(producto);

        return new ApiResponse<>("Producto creado con éxito", null, savedProducto);
    }

    //Buscar producto por ID
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    //Eliminar producto
    public ApiResponse<String> deleteProductoById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        productoRepository.delete(producto);
        return new ApiResponse<>("Producto eliminado con éxito", null, null);
    }

    //Actualizar producto (Stock)
    public ApiResponse<Producto> updateProductoById(Long id, ProductoUpdateStockDTO productoUpdateStockDTO) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(productoUpdateStockDTO.getStock());
        Producto updatedProducto = productoRepository.save(producto);

        return new ApiResponse<>("Stock actualizado con éxito", null, updatedProducto);
    }
}
