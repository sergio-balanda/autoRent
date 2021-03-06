package ar.edu.unlam.tallerweb1.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("reservaDao")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ReservaDaoImpl implements ReservaDao {

	@Inject
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void guardarReserva(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(reserva);
	}

	@Override
	public Reserva buscarReservas(Integer idReserva) {
		final Session session = sessionFactory.getCurrentSession();
		Reserva reserva = (Reserva) session.createCriteria(Reserva.class)
				.add(Restrictions.eq("idReserva", idReserva))
				.uniqueResult();
		return reserva;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> listarReservas() {
		final Session session = sessionFactory.getCurrentSession();
		DetachedCriteria subConsultaAlquileres = DetachedCriteria.forClass(Alquiler.class,"A")
				.setProjection(Projections.property("A.fkReserva"));
		//		.createAlias("fkReserva","R")
		//		.setProjection(Projections.property("R.idReserva").as("idReserva"));
		return session.createCriteria(Reserva.class, "R")
				.add(Subqueries.propertyNotIn("R.idReserva", subConsultaAlquileres))
				.addOrder(Order.asc("R.idReserva"))
				.list();
	}

	@Override
	public void guardarActualizarReserva(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
	/*	Alquiler alquiler = new Alquiler();
		alquiler.setFkReserva(reserva);
		session.save(alquiler);*/
		session.saveOrUpdate(reserva);

	}

	@Override
	public Reserva UltimaReservaDeUnUsuario(Integer id) {
		final Session session = sessionFactory.getCurrentSession();
		Reserva reserva =  (Reserva) session.createCriteria(Reserva.class,"rv")
				.add(Restrictions.eq("rv.usuario.id", id))
				// .setProjection(Projections.max("rv.idReserva"))
				.addOrder(Order.desc("rv.idReserva"))
				.setMaxResults(1)
				.uniqueResult();
		return reserva;
	}

}