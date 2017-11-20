package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("accesorioDao")
public class AccesorioDaoImpl implements AccesorioDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Accesorio buscarAccesorios(Integer idAccesorio) {
		final Session session = sessionFactory.getCurrentSession();
		Accesorio accesorio = (Accesorio) session.createCriteria(Accesorio.class)
				.add(Restrictions.eq("idAccesorio", idAccesorio)).uniqueResult();
		return accesorio;
	}

	@Override
	public List<Accesorio> listarAccesorios() {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Accesorio.class).list();
	}

}// fin
