package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorReserva {
	
	@Inject
	private ServicioVehiculo servicioVehiculo;
	@Inject
	private ServicioReserva servicioReserva;

	
	@RequestMapping("/generaReserva")
	public ModelAndView generaReserva (@RequestParam ("idVehiculo") Integer idVehiculo,
									   @RequestParam ("fchdesde") String fDesde,
									   @RequestParam ("fchhasta") String fHasta,
									   @RequestParam ("sucursal") String suc) {	
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculo", servicioVehiculo.buscarVehiculos(idVehiculo));
		modelo.put("idVehiculo", idVehiculo);
		modelo.put("fdsd", fDesde);
		modelo.put("fhst", fHasta);
		modelo.put("suc", suc);
		modelo.put("cost", servicioReserva.calcularCostoOrigen(fDesde, fHasta, idVehiculo));
		return new ModelAndView("reserva",modelo);
	}
	
	@RequestMapping("/guardaReserva")
	public ModelAndView guardaReserva (@RequestParam ("idVehiculo") Integer idVehiculo,
									    @RequestParam ("idVehiculo") Integer fkVehiculo,
			   							@RequestParam ("fchdesde") String fDesde,
									   @RequestParam ("fchhasta") String fHasta,
									   @RequestParam ("sucursal") String suc) {
		ModelMap modelo = new ModelMap();
		modelo.put("idVehiculo", idVehiculo);
		modelo.put("fdsd", fHasta);
		modelo.put("fhst", fHasta);
		modelo.put("suc",suc);
		servicioReserva.guardarReserva(idVehiculo, suc, fDesde, fHasta, fkVehiculo);
		return new ModelAndView("exito",modelo);
	}

}