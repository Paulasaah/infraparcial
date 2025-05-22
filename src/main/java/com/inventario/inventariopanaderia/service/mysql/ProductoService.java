package com.inventario.inventariopanaderia.service.mysql;


import com.inventario.inventariopanaderia.model.mysql.Producto;
import com.inventario.inventariopanaderia.repository.mysql.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public void guardar(Producto producto) {
        repository.save(producto);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Producto obtener(Long id) {
        return repository.findById(id).orElse(null);
    }
}