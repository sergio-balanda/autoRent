package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;




@Controller
public class ControladorFront {
	
	@Inject
	private ServicioVehiculo servicioVehiculo;


	@RequestMapping("/vehiculos")
	public ModelAndView verVehiculos(@RequestParam("cantidad") Integer cant) {
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculos", servicioVehiculo.listarVehiculosXPasajeros(cant));
		return new ModelAndView("vehiculos", modelo);
	}

	@RequestMapping(path = "/")
	public ModelAndView irAPrueba() {
		return new ModelAndView("index");
	}

	@RequestMapping("/pasajeros")
	public ModelAndView irAPasajero() {
		ModelMap modelo = new ModelMap();
		modelo.put("max", servicioVehiculo.maxPasajeros());
		return new ModelAndView("pasajeros", modelo);
	}
	
	

}//fin
