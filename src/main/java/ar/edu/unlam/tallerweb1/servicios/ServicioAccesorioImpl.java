package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AccesorioDao;
import ar.edu.unlam.tallerweb1.modelo.Accesorio;

@Service("servicioAccesorio")
@Transactional
public class ServicioAccesorioImpl implements ServicioAccesorio {

	@Inject
	private AccesorioDao accesorioDao;

	@Override
	public Accesorio buscarAccesorios(Integer idAccesorio) {
		return accesorioDao.buscarAccesorios(idAccesorio);
	}

	@Override
	public List<Accesorio> listarAccesorios() {
		return accesorioDao.listarAccesorios();
	}
	
	@Override
	public Double calcularPrecioPorAccesorios (ArrayList<Integer> accesorios, Long cantidadDeDias){
		return accesorioDao.calcularPrecioPorAccesorios(accesorios, cantidadDeDias);
	}

	@Override
	public List<Accesorio> buscarAccesoriosPorAlquiler(Integer idAlquiler) {
		return accesorioDao.buscarAccesoriosPorAlquiler(idAlquiler);
	}

}// fin
