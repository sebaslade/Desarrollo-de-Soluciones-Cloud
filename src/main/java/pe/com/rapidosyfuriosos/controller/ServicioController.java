package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.ServicioEntity;
import pe.com.rapidosyfuriosos.service.ServicioService;

@Controller
public class ServicioController {
	@Autowired
    private ServicioService servicio;

    // Listar solo servicios habilitados (o personalizados)
    @GetMapping("/servicio/listar")
    public String MostrarListarServicio(Model modelo) {
        modelo.addAttribute("listaservicio", servicio.findAllCustom());
        return "servicio/listar_servicio";
    }

    // Listar todos los servicios (habilitados y deshabilitados)
    @GetMapping("/servicio/habilitar")
    public String MostrarHabilitarServicio(Model modelo) {
        modelo.addAttribute("listaservicio", servicio.findAll());
        return "servicio/habilitar_servicio";
    }

    // Formulario de registro
    @GetMapping("/servicio/registro")
    public String MostrarRegistroServicio(Model modelo) {
        return "servicio/registrar_servicio";
    }

    // Formulario de actualización
    @GetMapping("/servicio/actualiza/{id}")
    public String MostrarActualizarServicio(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listaservicio", servicio.findById(id));
        return "servicio/actualizar_servicio";
    }

    // Eliminar (deshabilitar lógicamente)
    @GetMapping("/servicio/eliminar/{id}")
    public String EliminarServicio(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/servicio/listar";
    }

    // Habilitar servicio
    @GetMapping("/servicio/habilita/{id}")
    public String HabilitarServicio(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/servicio/habilitar";
    }

    // Deshabilitar servicio
    @GetMapping("/servicio/deshabilita/{id}")
    public String DeshabilitarServicio(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/servicio/habilitar";
    }

    // Modelo para formularios
    @ModelAttribute("servicio")
    public ServicioEntity ModeloServicio() {
        return new ServicioEntity();
    }

    // Registrar nuevo servicio
    @PostMapping("/servicio/registrar")
    public String RegistrarServicio(@ModelAttribute("servicio") ServicioEntity d) {
        servicio.add(d);
        return "redirect:/servicio/listar";
    }

    // Actualizar servicio existente
    @PostMapping("/servicio/actualizar/{id}")
    public String ActualizarServicio(@ModelAttribute("servicio") ServicioEntity d, @PathVariable Long id) {
        servicio.update(d, id);
        return "redirect:/servicio/listar";
    }
}
