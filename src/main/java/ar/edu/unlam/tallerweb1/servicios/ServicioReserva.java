package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioReserva {

	Reserva guardarReserva(Integer idVehiculo, String sucursal, String fdsd, String fhst, Integer fkVehiculo, Integer idUsuario);
	Reserva buscarReservas(Integer idReserva);
	List<Reserva> listarReservas();
	Reserva guardarActualizarReserva(Integer idReserva, String fechaInicio, String fechaFin, float costoOrigen, Integer fkVehiculoR, Integer id_usuario);
	Reserva UltimaReservaDeUnUsuario(Integer id);
	Double convertirCostoDeReservaDeUnUsuarioAPuntos(Integer idUsuario);
	long calcularCantidadDeDias(String fechaDesde, String fechaHasta);
	public void setReservaDao(ReservaDao reservaDao);

}