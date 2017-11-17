package ar.edu.unlam.tallerweb1.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Service("VehiculoDao")
public class VehiculoDaoImpl implements VehiculoDao {

	@Inject
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> listarVehiculosXPasajeros(Integer cantidadPasajeros, String sucursal, String fechaDesde , String fechaHasta ) {
        // CAST de String To Date
		DateFormat formatoFechaDesde = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatoFechaHasta = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateDesde = new Date();
		try {
			dateDesde = formatoFechaDesde.parse(fechaDesde);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dateHasta = new Date();
		try {
			dateHasta = formatoFechaHasta.parse(fechaHasta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -----------FIN CAST
       
		final Session session = sessionFactory.getCurrentSession();
		
		Criterion cond1 = Restrictions.and(Restrictions.ge("fechaInicio",dateDesde),Restrictions.le("fechaInicio",dateHasta) );
		Criterion cond2 = Restrictions.and(Restrictions.ge("fechaFin",dateDesde),Restrictions.le("fechaFin",dateHasta) );
		
		Integer fkV = (Integer)session.createCriteria(Reserva.class)
					  .add(Restrictions.and(cond1,cond2))
					  .setProjection(Projections.projectionList().add(Projections.property("reserva.fkVehiculoR")))
					  .uniqueResult();
					  
		
		List<Vehiculo> vehiculos = session.createCriteria(Vehiculo.class,"v")
				.createAlias("fkSucursalV", "s")
				.add(Restrictions.ge("capacidadPasajeros", cantidadPasajeros))
				.add(Restrictions.eq("s.ciudad", sucursal))
				 .add( Restrictions.ne("v.fkVehiculoR",fkV))
				.addOrder(Order.asc("capacidadPasajeros"))
				.list();
		
		//fkVehiculoR <> ( select r1_.fkVehiculoR from reserva r1_ where 
		//	( ( r1_.fechaInicio between '2017-11-01' and '2017-11-01' ) and ( r1_.fechaFin between '2017-11-01' and '2017-11-01' ) ) ) ;
		
		return vehiculos;
	}

	@Override
	public Integer maxPasajeros() {
		final Session session = sessionFactory.getCurrentSession();
		Integer maximaCantidadPasajeros  = (Integer)session.createCriteria(Vehiculo.class)
					.setProjection(Projections.max("capacidadPasajeros"))
					.uniqueResult();
		return maximaCantidadPasajeros;
	}
	
	@Override
	public Vehiculo buscarVehiculos(Integer idVehiculo) {
		final Session  session = sessionFactory.getCurrentSession();
		Vehiculo vehiculo = (Vehiculo) session.createCriteria(Vehiculo.class)
				.add(Restrictions.eq("idVehiculo", idVehiculo)).uniqueResult();
		return vehiculo;
	}
	
	@Override
	public List<Reserva> mostrarTodos(){
		final Session  session = sessionFactory.getCurrentSession();
		List<Reserva> reserva = session.createCriteria(Reserva.class)
							   .list();
		return reserva;
	}

	

}