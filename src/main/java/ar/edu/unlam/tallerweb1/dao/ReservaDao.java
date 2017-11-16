package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ReservaDao {

	void guardarReserva(Reserva reserva);

	Reserva guardarReservas(Integer idReserva, String fechaFinReserva);

	List<Reserva> listarReservas();
	
}