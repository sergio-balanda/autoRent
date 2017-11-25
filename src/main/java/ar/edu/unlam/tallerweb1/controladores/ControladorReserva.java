package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView generaReserva(@RequestParam("idVehiculo") Integer idVehiculo,
			@RequestParam("fechaDesde") String fechaDesde, @RequestParam("fechaHasta") String fechaHasta,
			@RequestParam("sucursal") String sucursal) {
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculo", servicioVehiculo.buscarVehiculos(idVehiculo));
		modelo.put("idVehiculo", idVehiculo);
		modelo.put("fechaDesde", fechaDesde);
		modelo.put("fechaHasta", fechaHasta);
		modelo.put("sucursal", sucursal);
		modelo.put("cantidadDias", servicioReserva.calcularCantidadDeDias(fechaDesde, fechaHasta));
		modelo.put("costoPorDia", servicioCategoria.verCostoDiario(idVehiculo));
		modelo.put("precioVehiculo", servicioCategoria.calcularCostoOrigen(fechaDesde, fechaHasta, idVehiculo));
		return new ModelAndView("reserva", modelo);
	}

	@RequestMapping(path = "/guardar-reserva", method = RequestMethod.POST)
	public ModelAndView guardaReserva(@RequestParam("idVehiculo") Integer idVehiculo,
			@RequestParam("idVehiculo") Integer fkVehiculo, @RequestParam("fechaDesde") String fechaDesde,
			@RequestParam("fechaHasta") String fechaHasta, @RequestParam("sucursal") String sucursal,@RequestParam (value="usuario") Integer idUsuario) {
		ModelMap modelo = new ModelMap();
		modelo.put("idVehiculo", idVehiculo);
		modelo.put("fechaDesde", fechaDesde);
		modelo.put("fechaHasta", fechaHasta);
		modelo.put("sucursal", sucursal);
		servicioReserva.guardarReserva(idVehiculo, sucursal, fechaDesde, fechaHasta, fkVehiculo,idUsuario);
		return new ModelAndView("exito", modelo);
	}

	@RequestMapping(path = "/iniciar-reserva", method = RequestMethod.POST)
	public ModelAndView iniciarReserva (){
		ModelMap modelo = new ModelMap();

		return new ModelAndView("iniciar-reserva", modelo);
	}

}