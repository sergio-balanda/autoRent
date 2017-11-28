package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;

public interface ServicioAlquilerAccesorio {
	
	void generarAlquilerAccesorio (Accesorio accesorio, Alquiler alquiler);
	
}