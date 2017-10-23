package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioBuscar;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Controller
public class ControladorPrueba {
	@Inject
	private ServicioVehiculo servicioVehiculo;
	
	public ServicioVehiculo getServicioVehiculo() {
		return servicioVehiculo;
	}

	public void setServicioVehiculo(ServicioVehiculo servicioVehiculo) {
		this.servicioVehiculo = servicioVehiculo;
	}
	
	@RequestMapping ("/vehiculos")
	public ModelAndView verVehiculos (){

		ModelMap modelo = new ModelMap();
		Vehiculo vehiculos = new Vehiculo();
		String patente=vehiculos.getPatente();
		
		modelo.put("vehiculos", vehiculos);
		modelo.put("patentes", patente);
		modelo.put("v", servicioVehiculo.listarVehiculos());
		return new ModelAndView ("vehiculos", modelo);
	}
	
	@RequestMapping(path="/")
	public ModelAndView irAPrueba()
	{
		return new ModelAndView("index");
	}
	@RequestMapping("/pasajeros")
	public ModelAndView irAPasajero ()
	{
		return new ModelAndView("pasajeros");
	}
	@RequestMapping("/reservar")
	public ModelAndView buscaCantidad (@RequestParam ("cantidad") Integer cantidad)
	{
		ModelMap modelo = new ModelMap();
		modelo.put("valor",cantidad);
		return new ModelAndView("pruebaok",modelo);
		
	}

}
