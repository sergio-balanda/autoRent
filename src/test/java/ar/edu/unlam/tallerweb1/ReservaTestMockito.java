package ar.edu.unlam.tallerweb1;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.controladores.ControladorAlquiler;
import ar.edu.unlam.tallerweb1.controladores.ControladorFront;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorReserva;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlquiler;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

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

	@SuppressWarnings("deprecation")
	@Test
	public void queEnControladorReservaSeListenLasReservas() {

		Reserva reservaUno = mock(Reserva.class);
		Reserva reservaDos = mock(Reserva.class);
		Reserva reservaTres = mock(Reserva.class);
		List<Reserva> listaReservas = new ArrayList<Reserva>();
		listaReservas.add(reservaUno);
		listaReservas.add(reservaDos);
		listaReservas.add(reservaTres);

		ControladorReserva controladorFake = new ControladorReserva();
		ServicioReserva servicioFake = mock(ServicioReserva.class);

		when(servicioFake.listarReservas()).thenReturn(listaReservas);
		controladorFake.setServicioReserva(servicioFake);

		ModelAndView miVista = controladorFake.listadoReservas();
		assertThat(miVista.getViewName()).isEqualTo("listado-reservas");
	//	Assert.assertEquals(servicioFake.listarReservas().size(), 3);
	}

	@Test
	public void sePruebaControladorLoginConExito() {

		Usuario usuarioFake = mock(Usuario.class);
		ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		HttpServletResponse responseFake = mock(HttpServletResponse.class);

		when(servicioLoginFake.consultarUsuario(usuarioFake)).thenReturn(usuarioFake);
		when(request.getSession()).thenReturn(session);
		ControladorLogin controlLogin = new ControladorLogin();

		controlLogin.setServicioLogin(servicioLoginFake);

		ModelAndView modeloVista = controlLogin.validarLogin(usuarioFake, request, responseFake);
		assertThat(modeloVista.getViewName()).isEqualTo("redirect:/index");
	}

	@Test
	public void testLoginComoAdministradorExitoso() {

		Usuario usuarioAdmin = mock(Usuario.class);
		ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession sesion = mock(HttpSession.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getSession()).thenReturn(sesion);
		when(usuarioAdmin.getAdministrador()).thenReturn(true);
		when(sesion.getAttribute("usuario")).thenReturn(usuarioAdmin);

		ControladorLogin controlLoginFake = new ControladorLogin();
		controlLoginFake.setServicioLogin(servicioLoginFake);
		when(servicioLoginFake.consultarUsuario(usuarioAdmin)).thenReturn(usuarioAdmin);

		ModelAndView model = controlLoginFake.validarLogin(usuarioAdmin, request, response);
		assertThat(model.getViewName()).isEqualTo("redirect:/listado-reservas");
	}
	/*
	 * @Test 
	 * public void sePruebaQueSePuedanListarVehiculosPorCantidadDePasajeros() { 
	 * // esta hecho para el controlador front
	 * // me devuelve siempre null el serviciofake falta algo!!!!
	 * 
	 * Integer cantidad = 4;
	 * 
	 * // SUCURSAL Sucursal sucursal = mock(Sucursal.class);
	 * when(sucursal.getCiudad()).thenReturn("Capital");
	 * 
	 * // VEHICULOS Vehiculo vehiculoUno = mock(Vehiculo.class); Vehiculo
	 * vehiculoDos = mock(Vehiculo.class); Vehiculo vehiculoTres =
	 * mock(Vehiculo.class);
	 * when(vehiculoUno.getFkSucursal()).thenReturn(sucursal);
	 * when(vehiculoUno.getIdVehiculo()).thenReturn(1);
	 * when(vehiculoUno.getCapacidadPasajeros()).thenReturn(5); //
	 * System.out.println(vehiculoUno.getFkSucursal().getCiudad());
	 * when(vehiculoDos.getFkSucursal()).thenReturn(sucursal);
	 * when(vehiculoUno.getCapacidadPasajeros()).thenReturn(2);
	 * 
	 * // LISTAR vehiculos List<Vehiculo> listaVehiculos = new
	 * ArrayList<Vehiculo>(); listaVehiculos.add(vehiculoUno);
	 * listaVehiculos.add(vehiculoDos); listaVehiculos.add(vehiculoTres);
	 * 
	 * ControladorFront controladorFake = new ControladorFront();
	 * ServicioVehiculo servicioFake = mock(ServicioVehiculo.class);
	 * 
	 * when(servicioFake.listarVehiculosXPasajeros(cantidad,
	 * sucursal.getCiudad(), "2011-01-01", "2017-01-02"))
	 * .thenReturn(listaVehiculos);
	 * 
	 * controladorFake.setServicioVehiculo(servicioFake);
	 * 
	 * ModelAndView miVista = controladorFake.elegirVehiculo(cantidad,
	 * sucursal.getCiudad(), "2017-01-01", "2017-01-02"); // vista-reservas es
	 * el return del controlador
	 * assertThat(miVista.getViewName()).isEqualTo("elegir-vehiculo");
	 * System.out.println(servicioFake.buscarVehiculos(1)); // me devulve
	 * siempre vacio algo me falta pero no lo veo. }
	 */
	/*
	 * @Test public void sePruebaQueSeNoSePuedaReservarUnVehiculoYaReservado() {
	 * 
	 * }
	 */

	@Test
	public void testQueSeIniciaUnAlquiler(){
		Reserva reserva = mock(Reserva.class);
		ServicioAlquiler alquilerService = mock(ServicioAlquiler.class);
		Alquiler alquiler = mock(Alquiler.class);	
		alquilerService.generarAlquiler(reserva, 1000.00);
		when(alquilerService.obtenerAlquilerConElIdReserva(reserva.getIdReserva())).thenReturn(alquiler);
		assertThat(alquiler.getFinalizada().equals(false));
	}
	
	/*
	@Test
	public void testQueIniciarAlquilerEnControladorPersisteElAlquiler() {
		Reserva reserva = mock(Reserva.class);
		ServicioAlquiler service = mock(ServicioAlquiler.class);
		Double costoFinal = 1500.00;
		ArrayList<Integer> accesoriosList = new ArrayList<Integer>();
		ControladorAlquiler control = new ControladorAlquiler();
		control.iniciarAlquiler(reserva.getIdReserva(), costoFinal, accesoriosList);
		verify(service).generarAlquiler(reserva, costoFinal);
	}
	*/
	
}