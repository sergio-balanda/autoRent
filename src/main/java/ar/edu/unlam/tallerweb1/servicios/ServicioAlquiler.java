package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.dao.AlquilerDao;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioAlquiler {
	
	void generarAlquiler(Reserva reserva, Double costoFinal);
	Alquiler buscarAlquiler(Integer idAlquiler);
	List<Alquiler> listarAlquileres();
	Alquiler obtenerAlquilerConElIdReserva (Integer idReserva);
	void finalizarAlquiler (Integer idAlquiler);
	void setAlquilerDao(AlquilerDao alquilerDao);
	
}