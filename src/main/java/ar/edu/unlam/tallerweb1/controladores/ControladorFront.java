package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorFront {

	@Inject
	private ServicioVehiculo servicioVehiculo;
	@Inject
	private ServicioSucursal servicioSucursal;


	@RequestMapping("/vehiculos")
	public ModelAndView verVehiculos(@RequestParam("cantidad") Integer cant, @RequestParam("sucursal") String sucursal) {
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculos", servicioVehiculo.listarVehiculosXPasajeros(cant, sucursal));
		return new ModelAndView("vehiculos", modelo);
	}

	@RequestMapping(path="/")
	public ModelAndView inicio() {
		return new ModelAndView("index");
	}

	@RequestMapping("/pasajeros")
	public ModelAndView selectPasajeros() {
		ModelMap modelo = new ModelMap();
		modelo.put("max", servicioVehiculo.maxPasajeros());
		modelo.put("sucursal", servicioSucursal.obtenerSucursales());
		return new ModelAndView("pasajeros", modelo);
	}

	
}