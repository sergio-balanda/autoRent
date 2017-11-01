package ar.edu.unlam.tallerweb1.controladores;


import java.util.Date;


import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

@Controller
public class ControladorFront {

	@Inject
	private ServicioVehiculo servicioVehiculo;
	@Inject
	private ServicioSucursal servicioSucursal;
	@Inject
	private ServicioReserva servicioReserva;


	@RequestMapping("/vehiculos")
	public ModelAndView verVehiculos(@RequestParam("cantidad") Integer cant, 
									 @RequestParam("sucursal") String sucursal,
									 @RequestParam("fch_desde") String fch_desde,
									 @RequestParam("fch_hasta") String fch_hasta) {
		ModelMap modelo = new ModelMap();
		modelo.put("vehiculos", servicioVehiculo.listarVehiculosXPasajeros(cant, sucursal , fch_desde , fch_hasta));
		modelo.put("sucursal", sucursal);
		modelo.put("fch_desde", fch_desde);
		modelo.put("fch_hasta", fch_hasta);
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


	

	
}//fin