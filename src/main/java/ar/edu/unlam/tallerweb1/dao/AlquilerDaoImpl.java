package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
		alquiler.setFinalizada(false);
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
				.add(Restrictions.eq("idAlquiler", idAlquiler))
				.uniqueResult();
		return alquiler;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alquiler> listarAlquileres() {
		final Session session = sessionFactory.getCurrentSession();
		List<Alquiler> alquileres = session.createCriteria(Alquiler.class, "A")
				.addOrder(Order.asc("A.finalizada"))
				.list();
		return alquileres;
	}
	
	@Override
	public Alquiler obtenerAlquilerConElIdReserva (Integer idReserva) {
		final Session session = sessionFactory.getCurrentSession();
		Alquiler alquiler = (Alquiler) session.createCriteria(Alquiler.class)
				.createAlias("fkReserva", "reserva")
				.add(Restrictions.eq("reserva.idReserva", idReserva))
				.uniqueResult();
		return alquiler;
	}
	
	@Override
	public void finalizarAlquiler (Integer idAlquiler) {
		final Session session = sessionFactory.getCurrentSession();
		Alquiler alquiler = (Alquiler) session.createCriteria(Alquiler.class)
				.add(Restrictions.eq("idAlquiler", idAlquiler))
				.uniqueResult();
		alquiler.setFinalizada(true);
		session.update(alquiler);
	}

}