package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Controller
public class VehiculoController {
	@RequestMapping("/pasajeros")
	public ModelAndView irautoRent(){
		ModelMap model = new ModelMap();
		Vehiculo miVehiculo = new Vehiculo();
		
		model.put("vehiculos", miVehiculo);
		
		
		return new ModelAndView("pasajeros",model);
		
	}
	
	@RequestMapping(path = "/reservar", method = RequestMethod.POST)
	public ModelAndView reservar(@RequestParam("cantidadDePersonas") Integer cantidadDePersonas,
			@ModelAttribute("vehiculo") Vehiculo vehiculo
			){
		ModelMap model = new ModelMap();
		
		//guardar la cantidad de select ver como obtenerla y mandarla a la vista 
        Integer cantidad=cantidadDePersonas;
        List<Vehiculo> lista= new ArrayList<Vehiculo>();
        
        
        
        
		switch (cantidad) {
		case 2:
			Vehiculo uno = new Vehiculo();
	        uno.setCantidadDePersonas(2);
	        uno.setPatente("unp");
	        Vehiculo dos = new Vehiculo();
	        dos.setCantidadDePersonas(2);
	        uno.setPatente("dos");
	        lista.add(uno);lista.add(dos);
			model.put("lista",lista);
			break;
		case 3:
			Vehiculo tres = new Vehiculo();
	        tres.setCantidadDePersonas(3);
	        tres.setPatente("tres");
	        tres.getPatente();
	        lista.add(tres);
	        model.put("lista", lista);
			break;
		default:
			
			break;
		}
		
		model.put("cantidad", cantidad);		
		//probar redirect no devolveria una nueva vista
		return new ModelAndView("confirma",model);
	}
}
