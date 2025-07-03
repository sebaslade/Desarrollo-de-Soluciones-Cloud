package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Controller
public class TipoDocumentoController {
	@Autowired
    private TipoDocumentoService servicio;

    @GetMapping("/tipodocumento/listar")
    public String MostrarListarTipodocumento(Model modelo) {
        modelo.addAttribute("listatipodocumento", servicio.findAllCustom());
        return "tipodocumento/listar_tipodocumento";
    }

    @GetMapping("/tipodocumento/habilitar")
    public String MostrarHabilitarTipodocumento(Model modelo) {
        modelo.addAttribute("listatipodocumento", servicio.findAll());
        return "tipodocumento/habilitar_tipodocumento";
    }

    @GetMapping("/tipodocumento/registro")
    public String MostrarRegistroTipodocumento(Model modelo) {
        return "tipodocumento/registrar_tipodocumento";
    }

    @GetMapping("/tipodocumento/actualiza/{id}")
    public String MostrarActualizarTipodocumento(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listatipodocumento", servicio.findById(id));
        return "tipodocumento/actualizar_tipodocumento";
    }

    @GetMapping("/tipodocumento/eliminar/{id}")
    public String EliminarTipodocumento(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tipodocumento/listar";
    }

    @GetMapping("/tipodocumento/habilita/{id}")
    public String HabilitarTipodocumento(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/tipodocumento/habilitar";
    }

    @GetMapping("/tipodocumento/deshabilita/{id}")
    public String DeshabilitarTipodocumento(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tipodocumento/habilitar";
    }

    @ModelAttribute("tipodocumento")
    public TipoDocumentoEntity ModeloTipodocumento() {
        return new TipoDocumentoEntity();
    }

    @PostMapping("/tipodocumento/registrar")
    public String RegistrarTipodocumento(@ModelAttribute("tipodocumento") TipoDocumentoEntity d) {
        servicio.add(d);
        return "redirect:/tipodocumento/listar";
    }

    @PostMapping("/tipodocumento/actualizar/{id}")
    public String ActualizarTipodocumento(@ModelAttribute("tipodocumento") TipoDocumentoEntity d, @PathVariable Long id) {
        servicio.update(d, id);
        return "redirect:/tipodocumento/listar";
    }
}
