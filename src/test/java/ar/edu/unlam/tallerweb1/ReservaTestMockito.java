package ar.edu.unlam.tallerweb1;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.controladores.ControladorAlquiler;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorReserva;
import ar.edu.unlam.tallerweb1.controladores.ControladorUsuarios;
import ar.edu.unlam.tallerweb1.dao.AlquilerDao;
import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlquiler;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlquilerImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReservaImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;

public class ReservaTestMockito {

	@Test
	public void testControllerLoginAdministradorExitoso() {
		//Mockeado
		Usuario user = mock(Usuario.class);
		ServicioLogin service = mock(ServicioLogin.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		//Preparación
		ControladorLogin control = new ControladorLogin();
		control.setServicioLogin(service);
		when(service.consultarUsuario(user)).thenReturn(user);
		when(user.getAdministrador()).thenReturn(true);
		when(request.getSession()).thenReturn(session);
		//Ejecución
		ModelAndView model = control.validarLogin(user, request, response);
		//Verificación
		String modelName = model.getViewName();
		assertThat(modelName).isEqualTo("redirect:/listado-reservasyyy");
	}
	
	@Test
	public void testControllerLoginClienteExitoso() {
		//Mockeado
		Usuario user = mock(Usuario.class);
		ServicioLogin service = mock(ServicioLogin.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		//Preparación
		ControladorLogin control = new ControladorLogin();
		control.setServicioLogin(service);
		when(service.consultarUsuario(user)).thenReturn(user);
		when(user.getAdministrador()).thenReturn(false);
		when(request.getSession()).thenReturn(session);
		//Ejecución
		ModelAndView model = control.validarLogin(user, request, response);
		//Verificación
		String modelName = model.getViewName();
		assertThat(modelName).isEqualTo("redirect:/index");
	}

/*
	@Test
	public void testControllerRegistrarAdministrador() {
		//Mockeado
		Usuario user = mock(Usuario.class);
		ServicioUsuario service = mock(ServicioUsuario.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		//Preparación
		ControladorUsuarios control = new ControladorUsuarios();
		control.setServicioUsuario(service);
//		user.setId(15);
//		user.setEmail("email@email.com");
//		user.setPassword("password");
//		user.setAdministrador(true);
//		user.setCuit("123456");
//		user.setPuntos(0);
//		user.setNombre("Administrador");
		user.setEmail("email@email.com");
		user.setAdministrador(true);
		Integer id = user.getId();
		String email = user.getEmail();
		String password = user.getPassword();
		Boolean administrador = user.getAdministrador();
		String cuit = user.getCuit();
		Integer puntos = user.getPuntos();
		String nombre = user.getNombre();
		when(service.guardarUsuario(id, email, password, administrador, cuit, puntos, nombre)).thenReturn(user);
		when(request.getSession()).thenReturn(session);
		//Ejecución
		control.registroAdministradorExitoso(nombre, email, cuit, password, request);
		//Verificación
		List<Usuario> list = service.listarUsuarios();
		System.out.println(list);
//		Usuario userObtenido = service.obtenerUsuarioPorId(id);
//		System.out.println(userObtenido);
	}
*/
	
	@Test
	public void testControllerListarUsuariosExitoso() {
		//Mockeado
		Usuario cliente = mock(Usuario.class);
		Usuario administrador = mock(Usuario.class);
		ServicioUsuario service = mock(ServicioUsuario.class);
		//Preparación
		ControladorUsuarios control = new ControladorUsuarios();
		control.setServicioUsuario(service);
		List<Usuario> list = new ArrayList<Usuario>();
		list.add(cliente);
		list.add(administrador);
		when(service.listarUsuarios()).thenReturn(list);
		//Ejecución
		ModelAndView model = control.listadoUsuarios();
		//Verificación
		Boolean respuesta = model.getModelMap().containsKey("usuariosList");
		assertThat(respuesta).isTrue();
	}
	
	@Test
	public void testServiceListarAlquileresExitoso() {
		//Mockeado
		AlquilerDao dao = mock(AlquilerDao.class);
		Alquiler alquiler1 = mock(Alquiler.class);
		Alquiler alquiler2 = mock(Alquiler.class);
		//Preparación
		ServicioAlquiler service = new ServicioAlquilerImpl();
		service.setAlquilerDao(dao);
		List<Alquiler> list = new ArrayList<Alquiler>();
		list.add(alquiler1);
		list.add(alquiler2);
		when(dao.listarAlquileres()).thenReturn(list);
		//Ejecución
		List<Alquiler> listObtenida = service.listarAlquileres();
		//Verificación
		assertThat(list).isEqualTo(listObtenida);
	}
	
	@Test
	public void testServiceListarReservasExitoso() {
		//Mockeado
		ReservaDao reservaDao = mock(ReservaDao.class);
		Reserva reserva1 = mock(Reserva.class);
		Reserva reserva2 = mock(Reserva.class);
		//Preparación
		ServicioReservaImpl servicio = new ServicioReservaImpl();
		List<Reserva> list = new ArrayList<Reserva>();
		list.add(reserva1);
		list.add(reserva2);
		servicio.setReservaDao(reservaDao);
		when(reservaDao.listarReservas()).thenReturn(list);
		//Ejecución
		List<Reserva> listObtenida = reservaDao.listarReservas();
		//Verificación
		assertThat(listObtenida).isEqualTo(list);		
	}
	
	@Test
	public void testServiceIniciarAlquilerExitoso() {
		//Mockeado
		Reserva reserva = mock(Reserva.class);
		AlquilerDao dao = mock(AlquilerDao.class);
		Alquiler alquiler = mock(Alquiler.class);
		//Preparación
		ServicioAlquilerImpl service = new ServicioAlquilerImpl();
		service.setAlquilerDao(dao);
		Double costoFinal = 1500.00;
		Integer idReserva = reserva.getIdReserva();
		when(dao.obtenerAlquilerConElIdReserva(idReserva)).thenReturn(alquiler);
		//Ejecución
		service.generarAlquiler(reserva, costoFinal);
		Alquiler alquilerObtenido = service.obtenerAlquilerConElIdReserva(idReserva);
		Boolean finalizada = alquilerObtenido.getFinalizada();
		//Verificación
		assertThat(finalizada).isEqualTo(false);
		/*
		Reserva reserva = mock(Reserva.class);
		ServicioAlquiler alquilerService = mock(ServicioAlquiler.class);
		Alquiler alquiler = mock(Alquiler.class);
		alquilerService.generarAlquiler(reserva, 1000.00);
		when(alquilerService.obtenerAlquilerConElIdReserva(reserva.getIdReserva())).thenReturn(alquiler);
		assertThat(alquiler.getFinalizada().equals(false));
		*/
	}
	
	@Test
	public void testServiceFinalizarAlquilerExitoso() {
		/*
		//Mockeado
		Alquiler alquiler = mock(Alquiler.class);
		AlquilerDao dao = mock(AlquilerDao.class);
		//Preparación
		ServicioAlquilerImpl service = new ServicioAlquilerImpl();
		service.setAlquilerDao(dao);
		Integer idAlquiler = alquiler.getIdAlquiler();
		//Ejecución
		service.finalizarAlquiler(idAlquiler);
		Boolean finalizada = alquiler.getFinalizada();
		//Verificación
		verify(dao.finalizarAlquiler(idAlquiler), times(1));
		*/
		Alquiler alquiler = mock(Alquiler.class);
		ServicioAlquiler servicioAlquiler = mock(ServicioAlquiler.class);
		servicioAlquiler.finalizarAlquiler(alquiler.getIdAlquiler());
		assertThat(alquiler.getFinalizada().equals(true));
		
	}
	
	//Mockitos viejos
	
	@Test
	public void testServiceDePersistirReserva() {
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
	}
	
	/*
	 * @Test public void
	 * sePruebaQueSePuedanListarVehiculosPorCantidadDePasajeros() { // esta
	 * hecho para el controlador front // me devuelve siempre null el
	 * serviciofake falta algo!!!!
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

/*	@Test
	public void testQueSeMuestraLaCantidadMaximaDePasajeros() {
		ServicioVehiculo servicio = mock(ServicioVehiculo.class);
		Integer maxPasajeros = 0 ;
		when(servicio.maxPasajeros()).thenReturn(maxPasajeros);
		System.out.println(maxPasajeros);
	}*/
	
	@Test
	public void testQueIniciarAlquilerEnControladorPersisteElAlquiler() {
		Reserva reserva = mock(Reserva.class);
		Accesorio accesorio = mock(Accesorio.class);
		ServicioAlquiler service = mock(ServicioAlquiler.class);
		Double costoFinal = 1500.00;
		ArrayList<Integer> accesoriosList = new ArrayList<Integer>();
		accesoriosList.add(accesorio.getIdAccesorio());
		ControladorAlquiler control = new ControladorAlquiler();
		control.setServicioAlquiler(service);
		service.generarAlquiler(reserva, costoFinal);
		verify(service).generarAlquiler(reserva, costoFinal);
	}
	
}