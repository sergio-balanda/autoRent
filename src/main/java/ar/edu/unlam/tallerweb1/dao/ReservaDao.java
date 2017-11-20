package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ReservaDao {

	void guardarReserva(Reserva reserva);

	Reserva buscarReservas(Integer idReserva);

	List<Reserva> listarReservas();

	void guardarActualizarReserva(Reserva reserva);

	Reserva UltimaReservaDeUnUsuario(Integer id);

}