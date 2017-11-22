package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

public class ReservaTestMockito {
	
	
	
	@Test
	public void testListarReservasExitoso(){
		List<Reserva> reservas = new ArrayList<>();
		Reserva reserva = mock(Reserva.class);
		ServicioReserva service = mock(ServicioReserva.class);
		when(service.listarReservas()).thenReturn(reservas);
		for (int i=0 ; i<5 ; i++){
			reserva.setIdReserva(i);
			reservas.add(i,reserva);
		}
		assertThat(reservas).hasSize(5);	
	}

	@Test
	public void testGuardarReservaExitoso(){
		Reserva reservaGuardar = mock(Reserva.class);
		Reserva reservaBuscar = mock(Reserva.class);
		ServicioReserva service = mock(ServicioReserva.class);
		when(service.guardarReserva(1, "Mar del Plata","2011-01-01", "2012-01-01", 1, 2)).thenReturn(reservaGuardar);
		when(service.buscarReservas(1)).thenReturn(reservaBuscar);
		assertThat(reservaGuardar.getFkVehiculoR()).isEqualTo(reservaBuscar.getFkVehiculoR());
	}

}
