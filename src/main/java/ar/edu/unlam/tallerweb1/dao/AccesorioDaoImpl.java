package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.Iterator;
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
	
/*	@Override
	public Double precioDelAccesorio (Integer idAccesorio) {
		final Session session = sessionFactory.getCurrentSession();
		Double valor = (Double) session.createCriteria(Accesorio.class)
				.add(Restrictions.eq("idAccesorio", idAccesorio)).uniqueResult();
	}*/

	@Override
	public Double calcularPrecioPorAccesorios (ArrayList<Integer> accesorios, Long cantidadDeDias) {
		Double sumaDePrecios = 0.0;
		for (Integer accesorio : accesorios) {
			Double costoDia = buscarAccesorios(accesorio).getCostoDia();
			sumaDePrecios += costoDia;
		}

		Double costoTotalDeAccesorios = sumaDePrecios * cantidadDeDias;
		return costoTotalDeAccesorios;
	}
}
