package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.MarcaEntity;
import pe.com.rapidosyfuriosos.service.MarcaService;

@Controller
public class MarcaController {
	@Autowired
    private MarcaService servicio;

    // Listar marcas activas
    @GetMapping("/marca/listar")
    public String MostrarListarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAllCustom());
        return "marca/listar_marca";
    }

    // Listar todas las marcas (habilitadas y deshabilitadas)
    @GetMapping("/marca/habilitar")
    public String MostrarHabilitarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAll());
        return "marca/habilitar_marca";
    }

    // Mostrar formulario de registro
    @GetMapping("/marca/registro")
    public String MostrarRegistroMarca(Model modelo) {
        return "marca/registrar_marca";
    }

    // Mostrar formulario de actualización
    @GetMapping("/marca/actualiza/{id}")
    public String MostrarActualizarMarca(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listamarca", servicio.findById(id));
        return "marca/actualizar_marca";
    }

    // Eliminar (deshabilitar lógicamente)
    @GetMapping("/marca/eliminar/{id}")
    public String EliminarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/listar";
    }

    // Habilitar marca
    @GetMapping("/marca/habilita/{id}")
    public String HabilitarMarca(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/marca/habilitar";
    }

    // Deshabilitar marca
    @GetMapping("/marca/deshabilita/{id}")
    public String DeshabilitarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/habilitar";
    }

    // Modelo vacío para los formularios
    @ModelAttribute("marca")
    public MarcaEntity ModeloMarca() {
        return new MarcaEntity();
    }

    // Guardar nueva marca
    @PostMapping("/marca/registrar")
    public String RegistrarMarca(@ModelAttribute("marca") MarcaEntity d) {
        servicio.add(d);
        return "redirect:/marca/listar";
    }

    // Actualizar marca existente
    @PostMapping("/marca/actualizar/{id}")
    public String ActualizarMarca(@ModelAttribute("marca") MarcaEntity d, @PathVariable Long id) {
        servicio.update(d, id);
        return "redirect:/marca/listar";
    }
}
