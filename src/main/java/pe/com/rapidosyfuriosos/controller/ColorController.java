package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.ColorEntity;
import pe.com.rapidosyfuriosos.service.ColorService;

@Controller
public class ColorController {
	@Autowired
    private ColorService servicio;

    @GetMapping("/color/listar")
    public String MostrarListarColor(Model modelo) {
        modelo.addAttribute("listacolor", servicio.findAllCustom());
        return "color/listar_color";
    }

    @GetMapping("/color/habilitar")
    public String MostrarHabilitarColor(Model modelo) {
        modelo.addAttribute("listacolor", servicio.findAll());
        return "color/habilitar_color";
    }

    @GetMapping("/color/registro")
    public String MostrarRegistroColor(Model modelo) {
        return "color/registrar_color";
    }

    @GetMapping("/color/actualiza/{id}")
    public String MostrarActualizarColor(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listacolor", servicio.findById(id));
        return "color/actualizar_color";
    }

    @GetMapping("/color/eliminar/{id}")
    public String EliminarColor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/color/listar";
    }

    @GetMapping("/color/habilita/{id}")
    public String HabilitarColor(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/color/habilitar";
    }

    @GetMapping("/color/deshabilita/{id}")
    public String DeshabilitarColor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/color/habilitar";
    }

    @ModelAttribute("color")
    public ColorEntity ModeloColor() {
        return new ColorEntity();
    }

    @PostMapping("/color/registrar")
    public String RegistrarColor(@ModelAttribute("color") ColorEntity d) {
        servicio.add(d);
        return "redirect:/color/listar";
    }

    @PostMapping("/color/actualizar/{id}")
    public String ActualizarColor(@ModelAttribute("color") ColorEntity d, @PathVariable Long id) {
        servicio.update(d, id);
        return "redirect:/color/listar";
    }
}
