package ar.edu.unlam.tallerweb1.servicios;

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
	public Reserva guardarReserva(Integer idVehiculo, String sucursal, String fDesde, String fHasta, Integer fkVehiculo,
			Integer idUsuario) {
		Reserva reserva = new Reserva();
		// CAST de String To Date
		SimpleDateFormat formatodsd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatohst = new SimpleDateFormat("yyyy-MM-dd");

		Date datedsd = new Date();
		try {
			datedsd = formatodsd.parse(fDesde);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date datehst = new Date();
		try {
			datehst = formatohst.parse(fHasta);
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
		reserva.setFechaInicio(datedsd);
		reserva.setFechaFin(datehst);
		reserva.setCostoOrigen(categoriaDao.calcularCostoOrigen(fDesde, fHasta, idVehiculo));
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

}