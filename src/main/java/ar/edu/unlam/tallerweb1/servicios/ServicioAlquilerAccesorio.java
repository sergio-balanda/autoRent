package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Accesorio;

public interface ServicioAlquilerAccesorio {
	
	void generarAlquilerAccesorio (ArrayList<Accesorio> listAccesorios, Integer idReserva);
}
