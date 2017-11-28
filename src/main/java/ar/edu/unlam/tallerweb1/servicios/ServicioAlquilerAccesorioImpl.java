package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.AlquilerAccesorioDao;
import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;

@Service("servicioAlquilerAccesorio")
@Transactional
public class ServicioAlquilerAccesorioImpl implements ServicioAlquilerAccesorio {
	
	@Inject
	private AlquilerAccesorioDao alquilerAccesorioDao;
	
	@Override
	public void generarAlquilerAccesorio (Accesorio accesorio, Alquiler alquiler) {
		alquilerAccesorioDao.generarAlquilerAccesorio (accesorio, alquiler);
	}

}