package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioReserva {
	
	public Reserva guardarReserva(Integer idVehiculo, String sucursal , String fdsd , String fhst,Integer fkVehiculo );
	public Reserva buscarReservas(Integer idReserva);

}