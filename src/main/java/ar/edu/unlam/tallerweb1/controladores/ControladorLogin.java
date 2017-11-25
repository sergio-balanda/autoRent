package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;

	@RequestMapping("/login")
	public ModelAndView irALogin(@RequestParam(value = "email", required = false) String email) {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();

		if (email != null && email != "") {
			usuario.setEmail(email);
		}

		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	// El método recibe un objeto Usuario el que tiene los datos ingresados en
	// el form correspondiente y
	// se corresponde con el modelAttribute definido en el tag form:form
	// HttpServletRequest devuelve una sesión de usuario.
	@RequestMapping(path = "/confirmar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request,
			HttpServletResponse response) {

		ModelMap modelo = new ModelMap();
		Usuario usuarioBuscar = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscar != null) {
			request.getSession().setAttribute("usuario", usuarioBuscar);

			if (usuarioBuscar.getAdministrador()) {
				// modelo.put("usuario", usuario);
				return new ModelAndView("redirect:/controlReservas");
			} else {
				// Redirije a index con el usuario logueado.
				return new ModelAndView("redirect:/index");
			}

		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			modelo.put("error", "Usuario o clave incorrecta");
		}

		return new ModelAndView("login", modelo);

	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute("usuario");
		return new ModelAndView("redirect:/index");
	}

	// test mockito
	public ServicioLogin getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

}// fin
