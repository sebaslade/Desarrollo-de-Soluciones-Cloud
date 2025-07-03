package pe.com.rapidosyfuriosos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;
import pe.com.rapidosyfuriosos.service.DistritoService;
import pe.com.rapidosyfuriosos.service.EmpleadoService;
import pe.com.rapidosyfuriosos.service.RolService;


@Controller
public class EmpleadoController {
	@Autowired
    private EmpleadoService servicio;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private RolService rolService;

    // Listar todos los empleados activos
    @GetMapping("/empleado/listar")
    public String MostrarListarEmpleado(Model modelo) {
        modelo.addAttribute("listaempleado", servicio.findAllCustom());
        return "empleado/listar_empleado";
    }

    // Mostrar todos (incluidos deshabilitados)
    @GetMapping("/empleado/habilitar")
    public String MostrarHabilitarEmpleado(Model modelo) {
        modelo.addAttribute("listaempleado", servicio.findAll());
        return "empleado/habilitar_empleado";
    }

    // Mostrar formulario de registro
    @GetMapping("/empleado/registro")
    public String MostrarRegistroEmpleado(Model modelo) {
        modelo.addAttribute("listadistrito", distritoService.findAll());
        modelo.addAttribute("listarol", rolService.findAll());
        return "empleado/registrar_empleado";
    }

    // Mostrar formulario de actualización
    @GetMapping("/empleado/actualiza/{id}")
    public String MostrarActualizarEmpleado(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("empleado", servicio.findById(id));
        modelo.addAttribute("listadistrito", distritoService.findAll());
        modelo.addAttribute("listarol", rolService.findAll());
        return "empleado/actualizar_empleado";
    }

    // Eliminar (deshabilitar) empleado
    @GetMapping("/empleado/eliminar/{id}")
    public String EliminarEmpleado(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/empleado/listar";
    }

    // Habilitar empleado
    @GetMapping("/empleado/habilita/{id}")
    public String HabilitarEmpleado(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/empleado/habilitar";
    }

    // Deshabilitar empleado
    @GetMapping("/empleado/deshabilita/{id}")
    public String DeshabilitarEmpleado(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/empleado/habilitar";
    }

    // Modelo vacío para formularios
    @ModelAttribute("empleado")
    public EmpleadoEntity ModeloEmpleado() {
        return new EmpleadoEntity();
    }

    // Registrar nuevo empleado
    @PostMapping("/empleado/registrar")
    public String RegistrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity e) {
        servicio.add(e);
        return "redirect:/empleado/listar";
    }

    // Actualizar empleado existente
    @PostMapping("/empleado/actualizar/{id}")
    public String ActualizarEmpleado(@ModelAttribute("empleado") EmpleadoEntity e, @PathVariable Long id) {
        servicio.update(e, id);
        return "redirect:/empleado/listar";
    }
}
