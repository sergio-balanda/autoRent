package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;

@Service("SucursalDao")
public class SucursalDaoImpl implements SucursalDao{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Sucursal> obtenerSucursales() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Sucursal> sucursales = session.createCriteria(Sucursal.class)
				.addOrder(Order.asc("idSucursal"))
				.list();
		return sucursales;
	}
	
	public Sucursal buscarSucXCiudad(String sucursal)
	{

		final Session session = sessionFactory.getCurrentSession();
		 Sucursal suc = (Sucursal) session.createCriteria(Sucursal.class)
				//.setProjection(Projections.projectionList().add(Projections.property("idSucursal")))
				.add(Restrictions.eq("ciudad",sucursal))
		        .uniqueResult();
		
		return suc; 
	}
	
}
