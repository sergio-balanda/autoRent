package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ReservaDao {

	void guardarReserva(Reserva reserva);

	Reserva buscarReservas(Integer idReserva);

	List<Reserva> listarReservas();
	
	//Integer guardarFecha(Integer idReserva,String fechaFinReserva);
	Integer guardarFecha(Reserva reserva);
}