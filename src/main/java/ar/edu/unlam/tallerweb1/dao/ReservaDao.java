package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ReservaDao {

    void guardarReserva(Reserva reserva);
    Reserva buscarReservas(Integer idReserva);
}