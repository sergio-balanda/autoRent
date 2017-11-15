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
	public ModelAndView mostrarReserva(@RequestParam("reserva") Integer idReserva) {
		ModelMap modelo = new ModelMap();
		modelo.put("reserva", servicioReserva.buscarReservas(idReserva));
		return new ModelAndView("detalle-reserva", modelo);
	}
	
	/*@RequestMapping(path="/actualizar-reserva",method=RequestMethod.POST)
	public ModelAndView actualizarReserva(@RequestParam("fechaFin") String fechaFinReserva,
										  @RequestParam("idReserva") Integer idReserva	)
	{
		ModelMap modelo = new ModelMap();
		Integer adicional = 0;
		adicional = servicioReserva.guardarFecha(idReserva,fechaFinReserva);
		modelo.put("precioAdicional",adicional);
		return new ModelAndView("vista-adicional",modelo);
		
	}*/
	
	@RequestMapping(path="/actualizar-reserva",method=RequestMethod.POST)
	public ModelAndView actualizarReserva(@ModelAttribute("reserva") Reserva reserva )
	{
		ModelMap modelo = new ModelMap();
		Integer adicional = 0;
		adicional = servicioReserva.guardarFecha(reserva);
		modelo.put("precioAdicional",adicional);
		return new ModelAndView("vista-adicional",modelo);
		
	}
	
}
