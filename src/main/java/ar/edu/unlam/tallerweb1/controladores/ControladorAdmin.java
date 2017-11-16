package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

@Controller
public class ControladorAdmin {
	@Inject
	private ServicioReserva servicioReserva;

	@RequestMapping("/listar-reservas")
	public ModelAndView listarReservas() {
		ModelMap modelo = new ModelMap();
		modelo.put("reservas", servicioReserva.listarReservas());
		return new ModelAndView("vista-reservas", modelo);
	}
	
	@RequestMapping(value = "/devolver-id-reserva", method = RequestMethod.GET)
	public ModelAndView mostrarReserva(@RequestParam("idReserva") Integer idReserva,
									   @RequestParam("fechaFinReserva") String fechaFinReserva) {
		ModelMap modelo = new ModelMap();
		modelo.put("reserva", servicioReserva.guardarReservas(idReserva,fechaFinReserva));
		return new ModelAndView("vista-reservas", modelo);
	}
	
}
