package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("alquilerDao")
public class AlquilerDaoImpl implements AlquilerDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void generarAlquiler(Reserva reserva, Double costoFinal) {
		final Session session = sessionFactory.getCurrentSession();
		Alquiler alquiler = new Alquiler();
		alquiler.setFkReserva(reserva);
		alquiler.setPrecioFinal(costoFinal);
		alquiler.setEstado("iniciado");
		session.save(alquiler);

	}

	@Override
	public void guardarAlquiler(Alquiler alquiler) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(alquiler);

	}

	@Override
	public Alquiler buscarAlquiler(Integer idAlquiler) {
		final Session session = sessionFactory.getCurrentSession();
		Alquiler alquiler = (Alquiler) session.createCriteria(Alquiler.class)
				.add(Restrictions.eq("idAlquiler", idAlquiler)).uniqueResult();
		return alquiler;
	}

	@Override
	public List<Alquiler> listarAlquileres() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Alquiler> alquileres = session.createCriteria(Alquiler.class).list();
		return alquileres;
	}

}
