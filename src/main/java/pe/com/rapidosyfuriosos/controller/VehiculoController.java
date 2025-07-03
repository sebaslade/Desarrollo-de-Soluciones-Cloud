package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.VehiculoEntity;
import pe.com.rapidosyfuriosos.service.ClienteService;
import pe.com.rapidosyfuriosos.service.ColorService;
import pe.com.rapidosyfuriosos.service.MarcaService;
import pe.com.rapidosyfuriosos.service.VehiculoService;



@Controller
public class VehiculoController {
	 @Autowired
	    private VehiculoService servicio;

	    @Autowired
	    private MarcaService marcaService;

	    @Autowired
	    private ColorService colorService;

	    @Autowired
	    private ClienteService clienteService;

	    // Mostrar listado de vehículos habilitados
	    @GetMapping("/vehiculo/listar")
	    public String MostrarListarVehiculo(Model modelo) {
	        modelo.addAttribute("listavehiculo", servicio.findAllCustom());
	        return "vehiculo/listar_vehiculo";
	    }

	    // Mostrar listado general (habilitados y deshabilitados)
	    @GetMapping("/vehiculo/habilitar")
	    public String MostrarHabilitarVehiculo(Model modelo) {
	        modelo.addAttribute("listavehiculo", servicio.findAll());
	        return "vehiculo/habilitar_vehiculo";
	    }

	    // Mostrar formulario de registro
	    @GetMapping("/vehiculo/registro")
	    public String MostrarRegistroVehiculo(Model modelo) {
	        modelo.addAttribute("listamarca", marcaService.findAll());
	        modelo.addAttribute("listacolor", colorService.findAll());
	        modelo.addAttribute("listacliente", clienteService.findAll());
	        return "vehiculo/registrar_vehiculo";
	    }

	    // Mostrar formulario de actualización
	    @GetMapping("/vehiculo/actualiza/{id}")
	    public String MostrarActualizarVehiculo(Model modelo, @PathVariable Long id) {
	        modelo.addAttribute("vehiculo", servicio.findById(id));
	        modelo.addAttribute("listamarca", marcaService.findAll());
	        modelo.addAttribute("listacolor", colorService.findAll());
	        modelo.addAttribute("listacliente", clienteService.findAll());
	        return "vehiculo/actualizar_vehiculo";
	    }

	    // Eliminar (deshabilitar) vehículo
	    @GetMapping("/vehiculo/eliminar/{id}")
	    public String EliminarVehiculo(@PathVariable Long id) {
	        servicio.delete(id);
	        return "redirect:/vehiculo/listar";
	    }

	    // Habilitar vehículo
	    @GetMapping("/vehiculo/habilita/{id}")
	    public String HabilitarVehiculo(@PathVariable Long id) {
	        servicio.enable(id);
	        return "redirect:/vehiculo/habilitar";
	    }

	    // Deshabilitar vehículo
	    @GetMapping("/vehiculo/deshabilita/{id}")
	    public String DeshabilitarVehiculo(@PathVariable Long id) {
	        servicio.delete(id);
	        return "redirect:/vehiculo/habilitar";
	    }

	    // Modelo vacío para formularios
	    @ModelAttribute("vehiculo")
	    public VehiculoEntity ModeloVehiculo() {
	        return new VehiculoEntity();
	    }

	    // Registrar nuevo vehículo
	    @PostMapping("/vehiculo/registrar")
	    public String RegistrarVehiculo(@ModelAttribute("vehiculo") VehiculoEntity v) {
	        servicio.add(v);
	        return "redirect:/vehiculo/listar";
	    }

	    // Actualizar vehículo existente
	    @PostMapping("/vehiculo/actualizar/{id}")
	    public String ActualizarVehiculo(@ModelAttribute("vehiculo") VehiculoEntity v, @PathVariable Long id) {
	        servicio.update(v, id);
	        return "redirect:/vehiculo/listar";
	    }
}
