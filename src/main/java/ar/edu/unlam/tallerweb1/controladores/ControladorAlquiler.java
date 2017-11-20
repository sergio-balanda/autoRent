package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioAccesorio;

@Controller
public class ControladorAlquiler {

	@Inject
	private ServicioAccesorio servicioAccesorio;

	@RequestMapping("/accesorios")
	public ModelAndView irAccesorios() {
		ModelMap modelo = new ModelMap();
		modelo.put("accesorios", servicioAccesorio.listarAccesorios());
		modelo.put("hola", "holll");
		return new ModelAndView("accesorios", modelo);
	}

}// fin
