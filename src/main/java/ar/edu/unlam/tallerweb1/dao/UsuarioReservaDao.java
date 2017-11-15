package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface UsuarioReservaDao {
    List<Reserva> obtenerReservasDeUnUserPorSuNombre(String nombre);

}
