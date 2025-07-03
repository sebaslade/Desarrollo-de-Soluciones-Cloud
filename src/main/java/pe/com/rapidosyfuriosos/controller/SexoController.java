package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.SexoEntity;
import pe.com.rapidosyfuriosos.service.SexoService;

@Controller
public class SexoController {
	@Autowired
    private SexoService servicio;

    @GetMapping("/sexo/listar")
    public String MostrarListarSexo(Model modelo) {
        modelo.addAttribute("listasexo", servicio.findAllCustom());
        return "sexo/listar_sexo";
    }

    @GetMapping("/sexo/habilitar")
    public String MostrarHabilitarSexo(Model modelo) {
        modelo.addAttribute("listasexo", servicio.findAll());
        return "sexo/habilitar_sexo";
    }

    @GetMapping("/sexo/registro")
    public String MostrarRegistroSexo(Model modelo) {
        return "sexo/registrar_sexo";
    }

    @GetMapping("/sexo/actualiza/{id}")
    public String MostrarActualizarSexo(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listasexo", servicio.findById(id));
        return "sexo/actualizar_sexo";
    }

    @GetMapping("/sexo/eliminar/{id}")
    public String EliminarSexo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/sexo/listar";
    }

    @GetMapping("/sexo/habilita/{id}")
    public String HabilitarSexo(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/sexo/habilitar";
    }

    @GetMapping("/sexo/deshabilita/{id}")
    public String DeshabilitarSexo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/sexo/habilitar";
    }

    @ModelAttribute("sexo")
    public SexoEntity ModeloSexo() {
        return new SexoEntity();
    }

    @PostMapping("/sexo/registrar")
    public String RegistrarSexo(@ModelAttribute("sexo") SexoEntity s) {
        servicio.add(s);
        return "redirect:/sexo/listar";
    }

    @PostMapping("/sexo/actualizar/{id}")
    public String ActualizarSexo(@ModelAttribute("sexo") SexoEntity s, @PathVariable Long id) {
        servicio.update(s, id);
        return "redirect:/sexo/listar";
    }
}
