package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioReserva {

	public Reserva guardarReserva(Integer idVehiculo, String sucursal, String fdsd, String fhst, Integer fkVehiculo,
			Integer idUsuario);

	public Reserva buscarReservas(Integer idReserva);

	public List<Reserva> listarReservas();

	Reserva guardarActualizarReserva(Integer idReserva, String fechaInicio, String fechaFin, float costoOrigen,
			Integer fkVehiculoR, Integer id_usuario);

	Reserva UltimaReservaDeUnUsuario(Integer id);

	Double convertirCostoDeReservaDeUnUsuarioAPuntos(Integer idUsuario);
	
	long calcularCantidadDeDias(String fechaDesde, String fechaHasta);

}