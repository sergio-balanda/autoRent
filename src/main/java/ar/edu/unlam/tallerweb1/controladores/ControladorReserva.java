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
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAccesorio;
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
	@Inject
	private ServicioAccesorio servicioAccesorio;

	@RequestMapping("/confirmar-reserva")
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
		return new ModelAndView("confirmar-reserva", modelo);
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
	
	@RequestMapping("/listado-reservas")
	public ModelAndView listadoReservas() {
		ModelMap modelo = new ModelMap();
		modelo.put("reservas", servicioReserva.listarReservas());
		return new ModelAndView("listado-reservas", modelo);
	}

	@RequestMapping(value = "/detalle-reserva", method = RequestMethod.GET)
	public ModelAndView verReserva(@RequestParam("reserva") Integer idReserva) {
		ModelMap modelo = new ModelMap();
		Reserva reserva = servicioReserva.buscarReservas(idReserva);
		Sucursal sucursal = reserva.getFkSucursalR();
		Vehiculo vehiculo = reserva.getFkVehiculoR();
		Usuario usuario = reserva.getUsuario();
		modelo.put("reserva", reserva);
		modelo.put("sucursal", sucursal);
		modelo.put("vehiculo", vehiculo);
		modelo.put("usuario", usuario);
		// lista de accesorios
		modelo.put("accesorios", servicioAccesorio.listarAccesorios());
		// Sistema de puntos
		modelo.put("convertir", servicioReserva.convertirCostoDeReservaDeUnUsuarioAPuntos(usuario.getId()));
		return new ModelAndView("detalle-reserva", modelo);
	}

	public void setServicioReserva(ServicioReserva servicioReserva) {
		this.servicioReserva = servicioReserva;
	}

}