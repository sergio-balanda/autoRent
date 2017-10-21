package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPrueba {
	@RequestMapping(path="/")
	public ModelAndView irAPrueba()
	{
		ModelMap modelo = new ModelMap();
		modelo.put("valor1", "PRUEBA OK" );
		return new ModelAndView("index",modelo);
	}

}
