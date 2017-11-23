package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorFront {

	@Inject
	private ServicioVehiculo servicioVehiculo;
	@Inject
	private ServicioSucursal servicioSucursal;

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
	public ModelAndView elegirVehiculo(@RequestParam("pasajeros") Integer cant, @RequestParam("sucursal") String sucursal,
			@RequestParam("fechaDesde") String fechaDesde, @RequestParam("fechaHasta") String fechaHasta) {
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculos", servicioVehiculo.listarVehiculosXPasajeros(cant, sucursal, fechaDesde, fechaHasta));
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

}