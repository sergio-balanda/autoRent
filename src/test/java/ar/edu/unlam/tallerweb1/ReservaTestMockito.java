package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorAdmin;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;

public class ReservaTestMockito {

	@Test
	public void testListarReservasExitoso() {
		List<Reserva> reservas = new ArrayList<>();
		Reserva reserva = mock(Reserva.class);
		ServicioReserva service = mock(ServicioReserva.class);
		when(service.listarReservas()).thenReturn(reservas);
		for (int i = 0; i < 5; i++) {
			reserva.setIdReserva(i);
			reservas.add(i, reserva);
		}
		assertThat(reservas).hasSize(5);
	}

	@Test
	public void testGuardarReservaExitoso() {
		Reserva reservaGuardar = mock(Reserva.class);
		Reserva reservaBuscar = mock(Reserva.class);
		ServicioReserva service = mock(ServicioReserva.class);
		when(service.guardarReserva(1, "Mar del Plata", "2011-01-01", "2012-01-01", 1, 2)).thenReturn(reservaGuardar);
		when(service.buscarReservas(1)).thenReturn(reservaBuscar);
		assertThat(reservaGuardar.getFkVehiculoR()).isEqualTo(reservaBuscar.getFkVehiculoR());
	}

	@Test
	public void queSelistenLasReservasEnAdmin() {
		// esta hecho para el controlador admin
		Reserva reservaUno = mock(Reserva.class);
		Reserva reservaDos = mock(Reserva.class);
		Reserva reservaTres = mock(Reserva.class);
		List<Reserva> listaReservas = new ArrayList<Reserva>();
		listaReservas.add(reservaUno);
		listaReservas.add(reservaDos);
		listaReservas.add(reservaTres);

		ControladorAdmin controladorFake = new ControladorAdmin();
		ServicioReserva servicioFake = mock(ServicioReserva.class);

		when(servicioFake.listarReservas()).thenReturn(listaReservas);
		// en controlador admin agregue, un metodo
		/*
		 * public void setServicioReserva(ServicioReserva servicioReserva) {
		 * this.servicioReserva = servicioReserva; }
		 * 
		 */
		controladorFake.setServicioReserva(servicioFake);
		// se hace referencia al controlador el metodo del modelandview se llama
		// verVistaReservas
		ModelAndView miVista = controladorFake.verVistaReservas();
		// vista-reservas es el return del controlador
		assertThat(miVista.getViewName()).isEqualTo("vista-reservas");
		// System.out.println(servicioFake.listarReservas().size());
	}

}
