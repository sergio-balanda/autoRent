package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AlquilerAccesorioDao;
import ar.edu.unlam.tallerweb1.modelo.Accesorio;

@Service("servicioAlquilerAccesorio")
@Transactional
public class ServicioAlquilerAccesorioImpl implements ServicioAlquilerAccesorio{
	@Inject
	private AlquilerAccesorioDao alquilerAccesorioDao;
	
	@Override
	public void generarAlquilerAccesorio (ArrayList<Accesorio> listAccesorios, Integer idReserva) {
		alquilerAccesorioDao.generarAlquilerAccesorio (listAccesorios, idReserva);
	}

}
