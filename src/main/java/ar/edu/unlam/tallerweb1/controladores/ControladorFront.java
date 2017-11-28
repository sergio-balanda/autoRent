package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAccesorio;
import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorFront {

	@Inject
	private ServicioVehiculo servicioVehiculo;
	@Inject
	private ServicioSucursal servicioSucursal;
	@Inject
	private ServicioAccesorio servicioAccesorio;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelMap modelo = new ModelMap();
		modelo.put("maximaCantidadPasajeros", servicioVehiculo.maxPasajeros());
		modelo.put("sucursal", servicioSucursal.obtenerSucursales());
		return new ModelAndView("index", modelo);
	}

	@RequestMapping(path = "/")
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping("/elegir-vehiculo")
	public ModelAndView elegirVehiculo(@RequestParam("pasajeros") Integer cant,
			@RequestParam("sucursal") String sucursal, @RequestParam("fechaDesde") String fechaDesde,
			@RequestParam("fechaHasta") String fechaHasta) {
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculos",servicioVehiculo.listarVehiculosXPasajeros(cant, sucursal, fechaDesde, fechaHasta));
		modelo.put("sucursal", sucursal);
		modelo.put("fechaDesde", fechaDesde);
		modelo.put("fechaHasta", fechaHasta);
		return new ModelAndView("elegir-vehiculo", modelo);
	}

	@RequestMapping("/listado-vehiculos")
	public ModelAndView verVehiculos() {
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculos", servicioVehiculo.listarVehiculos());
		return new ModelAndView("listado-vehiculos", modelo);
	}

	// test mockito
	public void setServicioVehiculo(ServicioVehiculo servicioVehiculo) {
		this.servicioVehiculo = servicioVehiculo;
	}
	
	@RequestMapping("/listado-accesorios")
	public ModelAndView listadoAccesorios() {
		ModelMap modelo = new ModelMap();
		modelo.put("accesorios", servicioAccesorio.listarAccesorios());
		return new ModelAndView("listado-accesorios", modelo);
	}

	@RequestMapping("/sucursales")
	public ModelAndView verSucursales() {
		ModelMap modelo = new ModelMap();
		List<Sucursal> sucursales = servicioSucursal.obtenerSucursales();
		modelo.put("sucursales", sucursales);
		return new ModelAndView("sucursales", modelo);
	}
}