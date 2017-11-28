package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Accesorio;

public interface AlquilerAccesorioDao {
	
	void generarAlquilerAccesorio (ArrayList<Accesorio> listAccesorios, Integer idReserva);
}

