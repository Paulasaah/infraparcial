package com.inventario.inventariopanaderia.repository.mysql;


import com.inventario.inventariopanaderia.model.mysql.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}