package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Service("VehiculoDao")
public class VehiculoDaoImpl implements VehiculoDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<Vehiculo> listarVehiculosXPasajeros(Integer cant) {
		final Session session = sessionFactory.getCurrentSession();
		List<Vehiculo> vehiculos = session.createCriteria(Vehiculo.class)
				.add(Restrictions.ge("capacidadPasajeros", cant))
				.addOrder(Order.asc("capacidadPasajeros"))
				.list();
		return vehiculos;
	}

	@Override
	public Integer maxPasajeros() {
		final Session session = sessionFactory.getCurrentSession();
		Integer max  = (Integer) session.createCriteria(Vehiculo.class)
					.setProjection(Projections.max("capacidadPasajeros"))
					   .uniqueResult();
		return max;
	}

}
