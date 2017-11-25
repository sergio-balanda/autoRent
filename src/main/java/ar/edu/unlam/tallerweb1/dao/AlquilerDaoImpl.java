package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("alquilerDao")
public class AlquilerDaoImpl implements AlquilerDao{

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void generarAlquiler(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		Alquiler alquiler = new Alquiler();
		alquiler.setFkReserva(reserva);
		alquiler.setEstado("iniciado");
		session.save(alquiler);

	}

}
