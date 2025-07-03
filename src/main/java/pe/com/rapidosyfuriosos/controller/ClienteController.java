package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.ClienteEntity;
import pe.com.rapidosyfuriosos.service.ClienteService;
import pe.com.rapidosyfuriosos.service.DistritoService;
import pe.com.rapidosyfuriosos.service.SexoService;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService servicio;
	
	@Autowired
	private DistritoService distritoService;

	@Autowired
	private SexoService sexoService;

	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	// Listar clientes activos
    @GetMapping("/cliente/listar")
    public String MostrarListarCliente(Model modelo) {
        modelo.addAttribute("listacliente", servicio.findAllCustom());
        return "cliente/listar_cliente";
    }

    // Listar todos los clientes (incluyendo inactivos)
    @GetMapping("/cliente/habilitar")
    public String MostrarHabilitarCliente(Model modelo) {
        modelo.addAttribute("listacliente", servicio.findAll());
        return "cliente/habilitar_cliente";
    }

    // Mostrar formulario de registro
    @GetMapping("/cliente/registro")
    public String MostrarRegistroCliente(Model modelo) {
        modelo.addAttribute("listadistrito", distritoService.findAll());
        modelo.addAttribute("listasexo", sexoService.findAll());
        modelo.addAttribute("listatipodocumento", tipoDocumentoService.findAll());
        return "cliente/registrar_cliente";
    }

    // Mostrar formulario de edición
    @GetMapping("/cliente/actualiza/{id}")
    public String MostrarActualizarCliente(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("cliente", servicio.findById(id));
        modelo.addAttribute("listadistrito", distritoService.findAll());
        modelo.addAttribute("listasexo", sexoService.findAll());
        modelo.addAttribute("listatipodocumento", tipoDocumentoService.findAll());
        return "cliente/actualizar_cliente";
    }

    // Eliminar cliente (deshabilitar)
    @GetMapping("/cliente/eliminar/{id}")
    public String EliminarCliente(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/cliente/listar";
    }

    // Habilitar cliente
    @GetMapping("/cliente/habilita/{id}")
    public String HabilitarCliente(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/cliente/habilitar";
    }

    // Deshabilitar cliente
    @GetMapping("/cliente/deshabilita/{id}")
    public String DeshabilitarCliente(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/cliente/habilitar";
    }

    // Modelo vacío
    @ModelAttribute("cliente")
    public ClienteEntity ModeloCliente() {
        return new ClienteEntity();
    }

    // Guardar cliente nuevo
    @PostMapping("/cliente/registrar")
    public String RegistrarCliente(@ModelAttribute("cliente") ClienteEntity d) {
        servicio.add(d);
        return "redirect:/cliente/listar";
    }

    // Actualizar cliente existente
    @PostMapping("/cliente/actualizar/{id}")
    public String ActualizarCliente(@ModelAttribute("cliente") ClienteEntity d, @PathVariable Long id) {
        servicio.update(d, id);
        return "redirect:/cliente/listar";
    }
}
