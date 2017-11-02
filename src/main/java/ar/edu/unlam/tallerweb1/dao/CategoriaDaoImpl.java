package ar.edu.unlam.tallerweb1.dao;

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
	VehiculoDao vehiculoDao;

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		final Session s = sessionFactory.getCurrentSession();
		Categoria cat = (Categoria) s.createCriteria(Categoria.class)
				.add(Restrictions.eq("idCategoria", idCategoria)).uniqueResult();
		return cat;
	}
	
	@Override
	public float calcularCostoOrigen(String fDesde, String fHasta, Integer idVehiculo) {
		SimpleDateFormat formatodsd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatohst = new SimpleDateFormat("yyyy-MM-dd");
		Date dDesde = new Date();
		Date dHasta = new Date();
		try {
			dDesde = formatodsd.parse(fDesde);
			dHasta = formatohst.parse(fHasta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer idCategoria = vehiculoDao.buscarVehiculos(idVehiculo).getFkCategoriaV().getIdCategoria();
		float costoHora = buscarPorId(idCategoria).getCostoHora();
		long cant = (dHasta.getTime()-dDesde.getTime())/(1000*60*60*24);
		float costoOrigen = cant*costoHora;
		return costoOrigen;
	}
	
}