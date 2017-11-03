package ar.edu.unlam.tallerweb1.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Categoria;

@Service("categoriaDao")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class CategoriaDaoImpl implements CategoriaDao{

	@Inject
	private SessionFactory sessionFactory;
	@Inject 
	private VehiculoDao vehiculoDao;

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		final Session s = sessionFactory.getCurrentSession();
		Categoria cat = (Categoria) s.createCriteria(Categoria.class)
				.add(Restrictions.eq("idCategoria", idCategoria)).uniqueResult();
		return cat;
	}
	
	@Override
	public float calcularCostoOrigen(String fechaDesde, String fechaHasta, Integer idVehiculo) {
		DateFormat formatoFechaDesde = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatoFechaHasta = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDesde = new Date();
		Date dateHasta = new Date();
		try {
			dateDesde = formatoFechaDesde.parse(fechaDesde);
			dateHasta = formatoFechaHasta.parse(fechaHasta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer idCategoria = vehiculoDao.buscarVehiculos(idVehiculo).getFkCategoriaV().getIdCategoria();
		float costoHora = buscarPorId(idCategoria).getCostoHora();
		long cantidadDias = (dateHasta.getTime()-dateDesde.getTime())/(1000*60*60*24);
		float costoOrigen = cantidadDias*costoHora;
		return costoOrigen;
	}
	
}