package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;

public interface AlquilerAccesorioDao {
	
	void generarAlquilerAccesorio (Accesorio accesorio, Alquiler alquiler);
	
}