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
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuarios {

	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioLogin servicioLogin;

	@RequestMapping(path = "/registro-usuario", method = RequestMethod.GET)
	public ModelAndView registroCliente() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("registro-usuario", modelo);
	}

	@RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST)
	public ModelAndView registroClienteExitoso(@RequestParam String nombre, @RequestParam String email,
			@RequestParam String cuit, @RequestParam String password, HttpServletRequest request) {
		Usuario userLogin = servicioUsuario.guardarUsuario(null, email, password, null, cuit, null, nombre);
		Usuario usuarioBuscar = servicioLogin.consultarUsuario(userLogin);
		request.getSession().setAttribute("usuario", usuarioBuscar);
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping("/detalle-usuario")
	public ModelAndView irDetalleUsuario() {
		return new ModelAndView("detalle-usuario");
	}

}// fin
