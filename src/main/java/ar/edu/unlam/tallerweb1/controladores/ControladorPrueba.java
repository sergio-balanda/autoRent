package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerwe1.servicios.ServicioBuscar;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Controller
public class ControladorPrueba {
	@Inject
	private ServicioBuscar servicioBuscar;
	
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
		List<Vehiculo> vehiculosBuscados = servicioBuscar.buscarVehiculos;
		//Me trabe aca lo de arriba no se si esta bien.
		
		
		
		return new ModelAndView("login", modelo);
		
	}

}
