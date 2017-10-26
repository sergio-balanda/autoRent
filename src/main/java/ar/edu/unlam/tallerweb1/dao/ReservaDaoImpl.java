package ar.edu.unlam.tallerweb1.dao;

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
	public void guardarReserva(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(reserva);
	}
	
}
