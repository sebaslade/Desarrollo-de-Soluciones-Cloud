package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.DistritoEntity;
import pe.com.rapidosyfuriosos.service.DistritoService;

@Controller
public class DitritoController {
	@Autowired
	private DistritoService servicio;
	
	//Rutas
	@GetMapping("/distrito/listar")
	public String MostrarListarDistrito(Model modelo) {
		modelo.addAttribute("listadistrito", servicio.findAllCustom());
		return "distrito/listar_distrito";
	}
	
	@GetMapping("/distrito/habilitar")
	public String MostrarHabilitarDistrito(Model modelo) {
		modelo.addAttribute("listadistrito", servicio.findAll());
		return "distrito/habilitar_distrito";
	}
	
	@GetMapping("/distrito/registro")
	public String MostrarRegistroDistrito(Model modelo) {
		return "distrito/registrar_distrito";
	}
	
	@GetMapping("/distrito/actualiza/{id}")
	public String MostrarActualizaDistrito(Model modelo, @PathVariable Long id) {
		modelo.addAttribute("listadistrito", servicio.findById(id));
		return "distrito/actualizar_distrito";
	}
	
	@GetMapping("/distrito/eliminar/{id}")
	public String EliminarDistrito(@PathVariable Long id) {
		servicio.delete(id);
		return "redirect:/distrito/listar";
	}
	
	@GetMapping("/distrito/habilita/{id}")
	public String HabilitarDistrito(@PathVariable Long id) {
		servicio.enable(id);
		return "redirect:/distrito/habilitar";
	}
	
	@GetMapping("/distrito/deshabilita/{id}")
	public String DeshabilitaDistrito(@PathVariable Long id) {
		servicio.delete(id);
		return "redirect:/distrito/habilitar";
	}
	
	@ModelAttribute("distrito")
	public DistritoEntity ModeloDistrito() {
		return new DistritoEntity();
	}
	
	@PostMapping("/distrito/registrar")
	public String RegistrarDistrito(@ModelAttribute("distrito") DistritoEntity d) {
		servicio.add(d);
		return "redirect:/distrito/listar";
	}
	
	@PostMapping("/distrito/actualizar/{id}")
	public String ActualizarDistrito(@ModelAttribute("distrito") DistritoEntity d, @PathVariable Long id) {
		servicio.update(d, id);
		return "redirect:/distrito/listar";
	}
}
