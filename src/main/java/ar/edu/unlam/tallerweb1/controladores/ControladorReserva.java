package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorReserva {
	
	@Inject
	private ServicioVehiculo servicioVehiculo;
	@Inject
	private ServicioReserva servicioReserva;
	@Inject
	private ServicioCategoria servicioCategoria;

	@RequestMapping("/generar-reserva")
	public ModelAndView generaReserva (@RequestParam ("idVehiculo") Integer idVehiculo,
									   @RequestParam ("fechaDesde") String fechaDesde,
									   @RequestParam ("fechaHasta") String fechaHasta,
									   @RequestParam ("sucursal") String sucursal) {	
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculo", servicioVehiculo.buscarVehiculos(idVehiculo));
		modelo.put("idVehiculo", idVehiculo);
		modelo.put("fechaDesde", fechaDesde);
		modelo.put("fechaHasta", fechaHasta);
		modelo.put("sucursal", sucursal);
		modelo.put("precioVehiculo", servicioCategoria.calcularCostoOrigen(fechaDesde, fechaHasta, idVehiculo));
		return new ModelAndView("reserva",modelo);
	}
	
	@RequestMapping("/guardar-reserva")
	public ModelAndView guardaReserva (@RequestParam ("idVehiculo") Integer idVehiculo,
									    @RequestParam ("idVehiculo") Integer fkVehiculo,
			   							@RequestParam ("fechaDesde") String fechaDesde,
									   @RequestParam ("fechaHasta") String fechaHasta,
									   @RequestParam ("sucursal") String sucursal) {
		ModelMap modelo = new ModelMap();
		modelo.put("idVehiculo", idVehiculo);
		modelo.put("fechaDesde", fechaHasta);
		modelo.put("fechaDesde", fechaHasta);
		modelo.put("sucursal",sucursal);
		servicioReserva.guardarReserva(idVehiculo, sucursal, fechaDesde, fechaHasta, fkVehiculo);
		return new ModelAndView("exito",modelo);
	}

}