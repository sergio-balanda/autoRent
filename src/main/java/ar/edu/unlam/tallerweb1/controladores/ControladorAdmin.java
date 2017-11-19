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

	@RequestMapping(value = "/detalle-reserva", method = RequestMethod.GET)
	public ModelAndView helloWorld(@RequestParam("reserva") Integer reserva) {
		ModelMap modelo = new ModelMap();
		modelo.put("idReserva", reserva);
		modelo.put("reserva", servicioReserva.buscarReservas(reserva));
		modelo.put("FkSucursalR", servicioReserva.buscarReservas(reserva).getFkSucursalR().getIdSucursal());
		modelo.put("fkVehiculoR", servicioReserva.buscarReservas(reserva).getFkVehiculoR().getIdVehiculo());
		modelo.put("id_usuario", servicioReserva.buscarReservas(reserva).getUsuario().getId());

		return new ModelAndView("detalle-reserva", modelo);
	}

	@RequestMapping(path = "/actualizar-reserva", method = RequestMethod.POST)
	public ModelAndView actualizarReserva(@RequestParam("idReserva") Integer idReserva,
			@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin,
			@RequestParam("costoOrigen") float costoOrigen, @RequestParam("fkVehiculoR") Integer fkVehiculoR,
			@RequestParam("finalizada") Boolean finalizada,
			@RequestParam("idUsuario") Integer idUsuario) {
		servicioReserva.guardarActualizarReserva(idReserva, fechaInicio, fechaFin, costoOrigen, fkVehiculoR,finalizada, idUsuario);
		return new ModelAndView("redirect:/vista-reservas");

	}

}// fin
