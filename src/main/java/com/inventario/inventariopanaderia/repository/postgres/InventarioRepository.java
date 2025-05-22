package com.inventario.inventariopanaderia.repository.postgres;

import com.inventario.inventariopanaderia.model.postgres.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}