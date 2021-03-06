package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface AlquilerDao {

	void generarAlquiler(Reserva reserva, Double costoFinal);

	void guardarAlquiler(Alquiler alquiler);

	Alquiler buscarAlquiler(Integer idAlquiler);

	List<Alquiler> listarAlquileres();

	Alquiler obtenerAlquilerConElIdReserva(Integer idReserva);

	void finalizarAlquiler(Integer idAlquiler);
}
