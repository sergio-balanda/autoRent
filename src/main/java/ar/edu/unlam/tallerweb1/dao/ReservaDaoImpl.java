package ar.edu.unlam.tallerweb1.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("reservaDao")
@Transactional
public class ReservaDaoImpl implements ReservaDao{

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void guardarReserva(Integer idVehiculo, String sucursal , String fdsd , String fhst) {
		final Session session = sessionFactory.getCurrentSession();
		
		 // CAST de String To Date
		SimpleDateFormat formatodsd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatohst = new SimpleDateFormat("yyyy-MM-dd");
		
		Date datedsd = new Date();
		try {
			datedsd = formatodsd.parse(fdsd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date datehst = new Date();
		try {
			datehst = formatohst.parse(fhst);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -----------FIN CAST
		
		Reserva reserva = new Reserva();
		reserva.getFkVehiculo().setIdVehiculo(idVehiculo);
		reserva.getFkSucursalR().setCiudad(sucursal);
		reserva.setFechaInicio(datedsd);
		reserva.setFechaFin(datehst);
		reserva.setCostoOrigen(0D);
		session.save(reserva);
	}
	
}