package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioReserva {
	
	public Reserva guardarReserva(Long idReserva, Long fkSucursalR, Long fkVehiculoR, 
			Date fechaInicio, Date fechaFin, Double costoOrigen);

}
