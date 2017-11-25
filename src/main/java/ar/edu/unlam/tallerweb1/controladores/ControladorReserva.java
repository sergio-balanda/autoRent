package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorReserva {

	@Inject
	private ServicioVehiculo servicioVehiculo;
	@Inject
	private ServicioReserva servicioReserva;
	@Inject
	private ServicioCategoria servicioCategoria;
	@Inject
	private ServicioSucursal servicioSucursal;

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
			@RequestParam("fechaHasta") String fechaHasta, @RequestParam("sucursal") String ciudadSucursal,
			@RequestParam(value = "usuario") Integer idUsuario) {
		ModelMap modelo = new ModelMap();
		modelo.put("fechaDesde", fechaDesde);
		modelo.put("fechaHasta", fechaHasta);
		Sucursal sucursal = servicioSucursal.buscarSucXCiudad(ciudadSucursal);
		modelo.put("domicilioSucursal", sucursal.getDomicilio());
		modelo.put("ciudadSucursal", ciudadSucursal);
		Reserva reserva = servicioReserva.guardarReserva(idVehiculo, ciudadSucursal, fechaDesde, fechaHasta, fkVehiculo,
				idUsuario);
		modelo.put("idReserva", reserva.getIdReserva());
		return new ModelAndView("guardar-reserva", modelo);
	}


	@RequestMapping(path = "/preparar-alquiler", method = RequestMethod.POST)
	public ModelAndView iniciarAlquiler(@RequestParam("accesorios") ArrayList<Integer> accesorios,
			@RequestParam("idReserva") Integer idReserva, @RequestParam("costoOrigen") Double costoOrigen,
			@RequestParam("fkVehiculoR") Integer idVehiculo, @RequestParam("fkSucursalR") Integer idSucursal,
			@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin) {
		ModelMap modelo = new ModelMap ();
		
		modelo.put("accesorios", accesorios);
		modelo.put("sucursal", servicioSucursal.buscarSucursales(idSucursal));
		modelo.put("vehiculo", servicioVehiculo.buscarVehiculos(idVehiculo));
		modelo.put("reserva", servicioReserva.buscarReservas(idReserva));
		modelo.put("cantidadDias", servicioReserva.calcularCantidadDeDias(fechaInicio, fechaFin));
		modelo.put("costoOrigen", costoOrigen);
		modelo.put("costoPorDia", servicioCategoria.verCostoDiario(idVehiculo));

		return new ModelAndView("preparar-alquiler", modelo);
	}

}