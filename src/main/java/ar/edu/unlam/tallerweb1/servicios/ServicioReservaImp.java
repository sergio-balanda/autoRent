package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("servicioComic")
@Transactional
public class ServicioReservaImp implements ServicioReserva {

	@Override
	public Reserva guardarReserva(Integer idReserva, Integer fkSucursalR, Integer fkVehiculoR, Date fechaInicio, Date fechaFin,
			Double costoOrigen) {
		Reserva reserva = new Reserva();
		reserva.setCostoOrigen(costoOrigen);
		reserva.setCostoOrigen(costoOrigen);
		reserva.setFechaFin(fechaFin);
		// dao buscar por id sucursal igual con vehiculo
		// reserva.setSucursal(sucursaldao.listarPorId);
		return reserva;
	}

}