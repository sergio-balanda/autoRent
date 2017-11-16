package ar.edu.unlam.tallerweb1.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("reservaDao")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ReservaDaoImpl implements ReservaDao {

	@Inject
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void guardarReserva(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(reserva);
	}

	@Override
	public Reserva guardarReservas(Integer idReserva,String fechaFinReserva) {
		final Session session = sessionFactory.getCurrentSession();
		Reserva reserva = (Reserva) session.createCriteria(Reserva.class).add(Restrictions.eq("idReserva", idReserva))
				.uniqueResult();
		// CAST de String To Date
		DateFormat fechaFinReservaFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateFinReserva = new Date();
		try {
			dateFinReserva = fechaFinReservaFormat.parse(fechaFinReserva);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -----------FIN CAST
		reserva.setFechaFin(dateFinReserva);
		session.update(reserva);
		return reserva;
	}

	@Override
	public List<Reserva> listarReservas() {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Reserva.class).list();
	}

}