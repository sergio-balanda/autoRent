package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AlquilerDao;
import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("servicioAlquiler")
@Transactional
public class ServicioAlquilerImpl implements ServicioAlquiler {

	@Inject
	private AlquilerDao alquilerDao;
	@Inject
	private ReservaDao reservaDao;

	@Override
	public void generarAlquiler(Reserva reserva, Double costoFinal) {
		alquilerDao.generarAlquiler(reserva, costoFinal);
	}

	@Override
	public Alquiler buscarAlquiler(Integer idAlquiler) {
		return alquilerDao.buscarAlquiler(idAlquiler);
	}

	@Override
	public Alquiler guardarAlquiler(Integer fkReserva, String estado, Double precioFinal) {
		Alquiler alquiler = null;

		alquiler = new Alquiler();

		alquiler.setEstado(estado);
		alquiler.setPrecioFinal(precioFinal);

		alquiler.setFkReserva(reservaDao.buscarReservas(fkReserva));
		alquilerDao.guardarAlquiler(alquiler);

		return alquiler;
	}

	@Override
	public List<Alquiler> listarAlquileres() {
		return alquilerDao.listarAlquileres();

	}

}