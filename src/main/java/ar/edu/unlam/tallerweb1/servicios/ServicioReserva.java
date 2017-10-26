package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioReserva {
	
	public Reserva guardarReserva(Integer idReserva, Integer fkSucursalR, Integer fkVehiculoR, 
			Date fechaInicio, Date fechaFin, Double costoOrigen);

}