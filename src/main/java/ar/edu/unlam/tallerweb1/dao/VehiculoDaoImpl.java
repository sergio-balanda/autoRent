package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	public List<Vehiculo> listarVehiculosXPasajeros(Integer cantidadPasajeros, String sucursal, String fechaDesde,
			String fechaHasta) {
		// convierto el string que viene del form de yyyy-mm-dd a yyyy-mm-dd
		// HH:mm:ss
		fechaDesde += " 23:59:59";
		fechaHasta += " 23:59:59";

		// CAST String To Date
		DateFormat formatoFechaDesde = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat formatoFechaHasta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

		final Session session = sessionFactory.getCurrentSession();

		// Genero una subquery que me trae una List de enteros con los
		// idVehiculos que no se pueden reservar en esa fecha
		List<Integer> fkVehiculoNoReserva = (List<Integer>) session.createCriteria(Reserva.class)
				.createAlias("fkVehiculoR", "v")
				.setProjection(Projections.projectionList().add(Projections.property("v.idVehiculo")))
				.add(Restrictions.and(Restrictions.and(Restrictions.le("fechaInicio", dateHasta),
						Restrictions.ge("fechaFin", dateDesde))))
				.list();

		// Si no hay ningun vehiculo que no se puede reservar (se puede reserva
		// cualquiera en esa fecha)
		if (fkVehiculoNoReserva.size() == 0)
			fkVehiculoNoReserva.add(0);

		// Query con la condicion de cantidad de pasajeros y sucursal y que no
		// este en la subquery anterior
		List<Vehiculo> vehiculos = session.createCriteria(Vehiculo.class, "v").createAlias("fkSucursalV", "s")
				.add(Restrictions.ge("v.capacidadPasajeros", cantidadPasajeros))
				.add(Restrictions.eq("s.ciudad", sucursal))
				.add(Restrictions.not(Restrictions.in("v.idVehiculo", fkVehiculoNoReserva)))
				.addOrder(Order.asc("v.capacidadPasajeros")).list();

		return vehiculos;
	}

	@Override
	public Integer maxPasajeros() {
		final Session session = sessionFactory.getCurrentSession();
		Integer maximaCantidadPasajeros = (Integer) session.createCriteria(Vehiculo.class)
				.setProjection(Projections.max("capacidadPasajeros")).uniqueResult();
		return maximaCantidadPasajeros;
	}

	@Override
	public Vehiculo buscarVehiculos(Integer idVehiculo) {
		final Session session = sessionFactory.getCurrentSession();
		Vehiculo vehiculo = (Vehiculo) session.createCriteria(Vehiculo.class)
				.add(Restrictions.eq("idVehiculo", idVehiculo)).uniqueResult();
		return vehiculo;
	}

	@Override
	public List<Reserva> mostrarTodos() {
		final Session session = sessionFactory.getCurrentSession();
		List<Reserva> reserva = session.createCriteria(Reserva.class).list();
		return reserva;
	}

}