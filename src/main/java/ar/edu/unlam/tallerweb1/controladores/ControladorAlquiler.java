package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
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

	
	@RequestMapping(path = "/guardar-accesorios", method = RequestMethod.POST)
	public ModelAndView guardarAccesorios(@RequestParam("accesorios") String accesorios) {
		ModelMap modelo = new ModelMap();
		modelo.put("accesorios", accesorios);
		return new ModelAndView("pruebas", modelo);
	}

	@RequestMapping(path = "/confirmar-alquiler", method = RequestMethod.POST)
	public ModelAndView confirmarAlquiler(@RequestParam("idReserva") Integer idReserva,
			@RequestParam("costoFinal") Double costoFinal) {
		ModelMap modelo = new ModelMap();
		servicioAlquiler.generarAlquiler(servicioReserva.buscarReservas(idReserva), costoFinal);
		modelo.put("costoFinal", costoFinal);
		modelo.put("idAlquiler", servicioAlquiler.obtenerAlquilerConElIdReserva(idReserva).getIdAlquiler());
		return new ModelAndView("confirmar-alquiler", modelo);
	}

	@RequestMapping(path = "/preparar-alquiler", method = RequestMethod.POST)
	public ModelAndView preparar(@RequestParam("idReserva") Integer idReserva,
			@RequestParam("idSucursal") Integer idSucursal, @RequestParam("idVehiculo") Integer idVehiculo,
			@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin,
			@RequestParam("costoOrigen") Double costoOrigen,
			@RequestParam("accesorios") ArrayList<Integer> accesorios) {
		ModelMap modelo = new ModelMap();
		List<Accesorio> listAccesorios = new ArrayList<Accesorio>();
		Long cantidadDias = servicioReserva.calcularCantidadDeDias(fechaInicio, fechaFin);
		Double costoTotalDeAccesorios = servicioAccesorio.calcularPrecioPorAccesorios(accesorios, cantidadDias);
		Double costoFinal = costoOrigen + costoTotalDeAccesorios;
		for(Integer accesorio: accesorios) {
			listAccesorios.add(servicioAccesorio.buscarAccesorios(accesorio));	
		}
		modelo.put("listAccesorios", listAccesorios);
		modelo.put("sucursal", servicioSucursal.buscarSucursales(idSucursal));
		modelo.put("vehiculo", servicioVehiculo.buscarVehiculos(idVehiculo));
		modelo.put("reserva", servicioReserva.buscarReservas(idReserva));
		modelo.put("cantidadDias", cantidadDias);
		modelo.put("costoPorDia", servicioCategoria.verCostoDiario(idVehiculo));
		modelo.put("costoOrigen", costoOrigen);
		modelo.put("costoTotalDeAccesorios", costoTotalDeAccesorios);
		modelo.put("costoFinal", costoFinal);
		return new ModelAndView("preparar-alquiler", modelo);
	}

	@RequestMapping(path = "finalizar-alquiler", method = RequestMethod.POST)
	public ModelAndView finalizarAlquiler(@RequestParam("idAlquiler") Integer idAlquiler) {
		ModelMap modelo = new ModelMap();
		modelo.put("idAlquiler", idAlquiler);
		servicioAlquiler.finalizarViaje(idAlquiler);
		return new ModelAndView("redirect:/control-reservas", modelo);
	}

	@RequestMapping("/listado-alquileres")
	public ModelAndView listadoAlquileres() {
		ModelMap modelo = new ModelMap();
		modelo.put("alquileres", servicioAlquiler.listarAlquileres());
		return new ModelAndView("listado-alquileres", modelo);
	}
	
	@RequestMapping(value = "/detalle-alquiler", method = RequestMethod.GET)
	public ModelAndView verAlquiler(@RequestParam("alquiler") Integer idAlquiler) {
		ModelMap modelo = new ModelMap();
		Alquiler alquiler = servicioAlquiler.buscarAlquiler(idAlquiler);
		Reserva reserva = alquiler.getFkReserva();
		Vehiculo vehiculo = reserva.getFkVehiculoR();
		Usuario usuario = reserva.getUsuario();
		Sucursal sucursal = reserva.getFkSucursalR();
		List<Accesorio> accesorios = servicioAccesorio.buscarAccesoriosPorAlquiler(idAlquiler);
		modelo.put("alquiler", alquiler);
		modelo.put("reserva", reserva);
		modelo.put("vehiculo", vehiculo);
		modelo.put("usuario", usuario);
		modelo.put("sucursal", sucursal);
		modelo.put("accesorios", accesorios);
		modelo.put("convertir", servicioReserva.convertirCostoDeReservaDeUnUsuarioAPuntos(usuario.getId()));
		return new ModelAndView("detalle-alquiler", modelo);
	}
	
}
