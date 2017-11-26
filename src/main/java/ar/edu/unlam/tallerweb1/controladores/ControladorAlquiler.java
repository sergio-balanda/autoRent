package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.servicios.ServicioAccesorio;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlquiler;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorAlquiler {

	@Inject
	private ServicioAccesorio servicioAccesorio;
	@Inject
	private ServicioSucursal servicioSucursal;
	@Inject
	private ServicioVehiculo servicioVehiculo;
	@Inject
	private ServicioReserva servicioReserva;
	@Inject
	private ServicioCategoria servicioCategoria;
	@Inject
	private ServicioAlquiler servicioAlquiler;


	@RequestMapping("/listado-accesorios")
	public ModelAndView irAccesorios() {
		ModelMap modelo = new ModelMap();
		modelo.put("accesorios", servicioAccesorio.listarAccesorios());
		return new ModelAndView("listado-accesorios", modelo);
	}

	@RequestMapping(path = "/guardar-accesorios", method = RequestMethod.POST)
	public ModelAndView guardarAccesorios(@RequestParam("accesorios") String accesorios) {
		ModelMap modelo = new ModelMap();
		modelo.put("accesorios", accesorios);
		return new ModelAndView("pruebas", modelo);
	}
	@RequestMapping(path = "/confirmar-alquiler", method = RequestMethod.POST)
	public ModelAndView confirmarAlquiler(@RequestParam("idReserva") Integer idReserva) {
		ModelMap modelo = new ModelMap();
		
		servicioAlquiler.generarAlquiler(servicioReserva.buscarReservas(idReserva));
		modelo.put("idReserva", idReserva);
		return new ModelAndView("confirmar-alquiler", modelo);
	}

	@RequestMapping(path = "/prepararAlquiler", method = RequestMethod.POST)
	public ModelAndView preparar(@RequestParam("idReserva") Integer idReserva,
			@RequestParam("idSucursal") Integer idSucursal, @RequestParam("idVehiculo") Integer idVehiculo,
			@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin,
			@RequestParam("costoOrigen") Double costoOrigen,
			@RequestParam("accesorios") ArrayList<Integer> accesorios) {
		ModelMap modelo = new ModelMap();
		Long cantidadDias = servicioReserva.calcularCantidadDeDias(fechaInicio, fechaFin);
		modelo.put("costoTotalDeAccesorios", servicioAccesorio.calcularPrecioPorAccesorios(accesorios, cantidadDias));
		modelo.put("accesorios", accesorios);
		modelo.put("sucursal", servicioSucursal.buscarSucursales(idSucursal));
		modelo.put("vehiculo", servicioVehiculo.buscarVehiculos(idVehiculo));
		modelo.put("reserva", servicioReserva.buscarReservas(idReserva));
		modelo.put("cantidadDias", cantidadDias);
		modelo.put("costoOrigen", costoOrigen);
		modelo.put("costoPorDia", servicioCategoria.verCostoDiario(idVehiculo));
		return new ModelAndView("prepararAlquiler", modelo);
	}

}// fin
