package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.RolEntity;
import pe.com.rapidosyfuriosos.service.RolService;

@Controller
public class RolController {
	@Autowired
    private RolService servicio;

    // Mostrar lista de roles activos (custom)
    @GetMapping("/rol/listar")
    public String MostrarListarRol(Model modelo) {
        modelo.addAttribute("listarol", servicio.findAllCustom());
        return "rol/listar_rol";
    }

    // Mostrar todos los roles (habilitados y deshabilitados)
    @GetMapping("/rol/habilitar")
    public String MostrarHabilitarRol(Model modelo) {
        modelo.addAttribute("listarol", servicio.findAll());
        return "rol/habilitar_rol";
    }

    // Mostrar formulario de registro
    @GetMapping("/rol/registro")
    public String MostrarRegistroRol(Model modelo) {
        return "rol/registrar_rol";
    }

    // Mostrar formulario de actualización
    @GetMapping("/rol/actualiza/{id}")
    public String MostrarActualizarRol(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarol", servicio.findById(id));
        return "rol/actualizar_rol";
    }

    // Eliminar (deshabilita lógicamente)
    @GetMapping("/rol/eliminar/{id}")
    public String EliminarRol(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/rol/listar";
    }

    // Habilitar rol
    @GetMapping("/rol/habilita/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/rol/habilitar";
    }

    // Deshabilitar rol
    @GetMapping("/rol/deshabilita/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/rol/habilitar";
    }

    // Modelo para los formularios
    @ModelAttribute("rol")
    public RolEntity ModeloRol() {
        return new RolEntity();
    }

    // Registrar nuevo rol
    @PostMapping("/rol/registrar")
    public String RegistrarRol(@ModelAttribute("rol") RolEntity d) {
        servicio.add(d);
        return "redirect:/rol/listar";
    }

    // Actualizar rol existente
    @PostMapping("/rol/actualizar/{id}")
    public String ActualizarRol(@ModelAttribute("rol") RolEntity d, @PathVariable Long id) {
        servicio.update(d, id);
        return "redirect:/rol/listar";
    }
}
