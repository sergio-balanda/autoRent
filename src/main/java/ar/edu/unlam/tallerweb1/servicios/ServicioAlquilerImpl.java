package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AlquilerDao;
import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Reserva;



@Service("servicioAlquiler")
@Transactional
public class ServicioAlquilerImpl implements ServicioAlquiler {

	@Inject
	private AlquilerDao alquilerDao;

	@Override
	public void generarAlquiler(Reserva reserva) {
		alquilerDao.generarAlquiler(reserva);
	}

}