package pe.com.rapidosyfuriosos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Controlle -> Define como Controlador a una clase
//Controlador es una clase que recibe peticiones (request)
//las procesa y devuelve respuestas(response)
@Controller
public class InicioController {
	//@GetMapping -> sirve para trabajar con rutas y algunas acciones
	//@PostMapping -> sirve para trabajar las acciones que generalmente son ejecutadas por un boton creamos una ruta para el index
	@GetMapping
	public String MostrarInicio() {
		return "index";
	}
	
	@GetMapping("/menuprincipal")
	public String MostrarMenuPrincipal() {
		return "menuprincipal";
	}
}
