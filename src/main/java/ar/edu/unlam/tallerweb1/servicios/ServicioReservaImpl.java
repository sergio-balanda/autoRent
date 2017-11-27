package ar.edu.unlam.tallerweb1.servicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.CategoriaDao;
import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioReserva")
@Transactional
public class ServicioReservaImpl implements ServicioReserva {

	@Inject
	private ReservaDao reservaDao;
	@Inject
	private VehiculoDao vehiculoDao;
	@Inject
	private SucursalDao sucursalDao;
	@Inject
	private CategoriaDao categoriaDao;
	@Inject
	private UsuarioDao usuarioDao;

	@Override
	public long calcularCantidadDeDias(String fechaDesde, String fechaHasta) {
		DateFormat formatoFechaDesde = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatoFechaHasta = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDesde = new Date();
		Date dateHasta = new Date();
		try {
			dateDesde = formatoFechaDesde.parse(fechaDesde);
			dateHasta = formatoFechaHasta.parse(fechaHasta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long cantidadDias = (dateHasta.getTime()-dateDesde.getTime())/(1000*60*60*24);
		if (cantidadDias == 0) {
			cantidadDias = 1;
		}
		return cantidadDias;
	}
	
	@Override
	public Reserva guardarReserva(Integer idVehiculo, String sucursal, String fechaDesde, String fechaHasta,
			Integer fkVehiculo, Integer idUsuario) {
		Reserva reserva = new Reserva();
		// CAST de String To Date
		SimpleDateFormat formatoDesde = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatoHasta = new SimpleDateFormat("yyyy-MM-dd");

		Date dateDesde = new Date();
		try {
			dateDesde = formatoDesde.parse(fechaDesde);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dateHasta = new Date();
		try {
			dateHasta = formatoHasta.parse(fechaHasta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -----------FIN CAST

		if (fkVehiculo != null) {
			reserva.setFkVehiculoR(vehiculoDao.buscarVehiculos(idVehiculo));
		}
		reserva.setUsuario(usuarioDao.obtenerUsuarioPorId(idUsuario));
		if (idUsuario != null) {
			Usuario usuario;
			usuario = usuarioDao.obtenerUsuarioPorId(idUsuario);
			Integer puntosAcuales = usuario.getPuntos();
			Integer sumarPuntos = puntosAcuales + 500;
			usuario.setPuntos(sumarPuntos);
			usuarioDao.guardarUsuario(usuario);
		}
		reserva.setFkSucursalR(sucursalDao.buscarSucXCiudad(sucursal));
		reserva.setFechaInicio(dateDesde);
		reserva.setFechaFin(dateHasta);
		reserva.setCostoOrigen(categoriaDao.calcularCostoOrigen(fechaDesde, fechaHasta, idVehiculo));
		reservaDao.guardarReserva(reserva);
		return reserva;
	}

	@Override
	public Reserva buscarReservas(Integer idReserva) {
		return reservaDao.buscarReservas(idReserva);
	}

	@Override
	public List<Reserva> listarReservas() {
		return reservaDao.listarReservas();
	}

	@Override
	public Reserva guardarActualizarReserva(Integer idReserva, String fechaInicio, String fechaFin, float costoOrigen,
			Integer fkVehiculoR, Boolean finalizada, Integer id_usuario) {
		Reserva reserva = null;
		// CAST de String To Date
		SimpleDateFormat formatodsd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatohst = new SimpleDateFormat("yyyy-MM-dd");

		Date datedsd = new Date();
		try {
			datedsd = formatodsd.parse(fechaInicio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date datehst = new Date();
		try {
			datehst = formatohst.parse(fechaFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (idReserva != null) {
			reserva = reservaDao.buscarReservas(idReserva);
		} else {
			reserva = new Reserva();
		}

		reserva.setCostoOrigen(costoOrigen);
		reserva.setFechaFin(datehst);


		reservaDao.guardarActualizarReserva(reserva);

		return reserva;
	}

	@Override
	public Reserva UltimaReservaDeUnUsuario(Integer id) {
		return reservaDao.UltimaReservaDeUnUsuario(id);

	}

	@Override
	public Double convertirCostoDeReservaDeUnUsuarioAPuntos(Integer idUsuario) {
		Double convertirCostoApuntos = null;
		Usuario usuario = usuarioDao.obtenerUsuarioPorId(idUsuario);
		Integer puntos = usuario.getPuntos();
		convertirCostoApuntos=(double) (puntos*5/1000);//1000*5/1000=5pesos
		return convertirCostoApuntos;
	}

}// fin