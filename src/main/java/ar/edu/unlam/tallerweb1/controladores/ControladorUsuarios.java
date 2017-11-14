package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuarios {

	@Inject
	private ServicioUsuario servicioUsuario;

	@RequestMapping(path = "/registro-usuario", method = RequestMethod.GET)
	public ModelAndView irARegistroUsuario() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("registro-usuario", modelo);
	}

	@RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST)
	public ModelAndView registrarUsuario(@RequestParam String nombre, @RequestParam String email,
			@RequestParam String cuit, @RequestParam String password, HttpServletRequest request) {

		servicioUsuario.guardarUsuario(null, email, password, null, cuit, null, nombre);

		return new ModelAndView("redirect:/registro-exitoso?username=" + nombre + "&usermail=" + email);
	}

	@RequestMapping(path = "/registro-exitoso", method = RequestMethod.GET)
	public ModelAndView registroExitoso(@RequestParam(value = "username") String nombre,
			@RequestParam(value = "usermail") String email) {
		ModelMap modelo = new ModelMap();
		modelo.put("username", nombre);
		modelo.put("usermail", email);
		return new ModelAndView("registro-usuario-exitoso", modelo);
	}

}// fin
