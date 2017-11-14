package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

@Controller
public class ControladorAdmin {
	@Inject
	private ServicioReserva servicioReserva;

	@RequestMapping("/vista-reservas")
	public ModelAndView verVistaReservas() {
		ModelMap modelo = new ModelMap();
		modelo.put("reservas", servicioReserva.listarReservas());
		return new ModelAndView("vista-reservas", modelo);
	}

	@RequestMapping("/detalle-reserva")
	public ModelAndView verDetalleReserva(@RequestParam("reserva") Integer reserva) {
		ModelMap modelo = new ModelMap();
		modelo.put("idReserva", reserva);
		modelo.put("reserva", servicioReserva.buscarReservas(reserva));
		return new ModelAndView("detalle-reserva");
	}
	
	@RequestMapping ("/devolver-vehiculo")
	public ModelAndView devolverVehiculo(){

		return new ModelAndView ("detalle-reserva");
	}
}
