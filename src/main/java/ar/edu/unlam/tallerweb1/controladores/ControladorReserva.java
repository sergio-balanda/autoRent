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
	public ModelAndView generaReserva (@RequestParam ("idVehiculo") Integer id,
									   @RequestParam ("idVehiculo") Integer fkVehiculo,
									   @RequestParam ("fchdesde") String fdsd,
									   @RequestParam ("fchhasta") String fhst,
									   @RequestParam ("sucursal") String suc)
	{	
		ModelMap modelo = new ModelMap();
		
		Integer idBuscar = id;
		modelo.put("vehiculo", servicioVehiculo.buscarhiculos(idBuscar));
		modelo.put("idVehiculo",id);
		modelo.put("fdsd",fdsd);
		modelo.put("fhst",fhst);
		modelo.put("suc",suc);
		return new ModelAndView("reserva",modelo);
	}
	
	@RequestMapping("/guardaReserva")
	public ModelAndView guardaReserva (@RequestParam ("idVehiculo") Integer id,
									    @RequestParam ("idVehiculo") Integer fkVehiculo,
			   							@RequestParam ("fchdesde") String fdsd,
									   @RequestParam ("fchhasta") String fhst,
									   @RequestParam ("sucursal") String suc)
	{
		ModelMap modelo = new ModelMap();
		modelo.put("idVehiculo",id);
		modelo.put("fdsd",fdsd);
		modelo.put("fhst",fhst);
		modelo.put("suc",suc);
		servicioReserva.guardarReserva(id, suc, fdsd, fhst, fkVehiculo);
		return new ModelAndView("exito",modelo);
	}

}