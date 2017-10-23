package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Service("VehiculoDao")
public class VehiculoDaoImpl implements VehiculoDao{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Vehiculo> listarVehiculos() {
		final Session session = sessionFactory.getCurrentSession();

		
		List<Vehiculo> vehiculos = session.createCriteria(Vehiculo.class).list();

		return vehiculos;
	}

}
