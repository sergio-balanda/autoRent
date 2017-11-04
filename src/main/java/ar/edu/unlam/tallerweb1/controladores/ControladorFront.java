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
		return new ModelAndView("index");
	}

	@RequestMapping(path = "/")
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping("/pasajeros")
	public ModelAndView selectPasajeros() {
		ModelMap modelo = new ModelMap();
		modelo.put("maximaCantidadVehiculos", servicioVehiculo.maxPasajeros());
		modelo.put("sucursal", servicioSucursal.obtenerSucursales());
		return new ModelAndView("pasajeros", modelo);
	}

	@RequestMapping("/vehiculos")
	public ModelAndView verVehiculos(@RequestParam("cantidad") Integer cant, @RequestParam("sucursal") String sucursal,
			@RequestParam("fechaDesde") String fechaDesde, @RequestParam("fechaHasta") String fechaHasta) {
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculos", servicioVehiculo.listarVehiculosXPasajeros(cant, sucursal, fechaDesde, fechaHasta));
		modelo.put("sucursal", sucursal);
		modelo.put("fechaDesde", fechaDesde);
		modelo.put("fechaHasta", fechaHasta);
		return new ModelAndView("vehiculos", modelo);
	}

}