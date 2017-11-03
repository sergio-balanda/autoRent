package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.CategoriaDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.Categoria;

@Service("servicioCategoria")
@Transactional
public class ServicioCategoriaImpl implements ServicioCategoria {

	@Inject 
	private CategoriaDao categoriaDao;
	@Inject 
	private VehiculoDao vehiculoDao;
	
	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		return categoriaDao.buscarPorId(idCategoria);
	}
	
	@Override
	public float calcularCostoOrigen(String fDesde, String fHasta, Integer idVehiculo) {
		return categoriaDao.calcularCostoOrigen(fDesde, fHasta, idVehiculo);
	}
	
}
