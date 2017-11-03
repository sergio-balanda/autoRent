package ar.edu.unlam.tallerweb1.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.CategoriaDao;
import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.modelo.Categoria;

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
	
	@Override
	public Reserva guardarReserva(Integer idVehiculo, String sucursal, String fDesde, String fHasta, Integer fkVehiculo) {
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
		
		if ( fkVehiculo!=null ) {
			reserva.setFkVehiculoR(vehiculoDao.buscarVehiculos(idVehiculo));
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

}