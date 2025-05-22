package com.inventario.inventariopanaderia.controller.mysql;


import com.inventario.inventariopanaderia.model.mysql.Producto;
import com.inventario.inventariopanaderia.service.mysql.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService servicio;

    public ProductoController(ProductoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", servicio.listar());
        return "productos"; // archivo productos.html
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario"; // archivo formulario.html
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
        producto.setOrigenBaseDatos("MySQL"); // Marcamos su origen
        servicio.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", servicio.obtener(id));
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/productos";
    }
}