package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.AlquilerAccesorio;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlquiler;


@Service("alquilerAccesorioDao")
public class AlquilerAccesorioDaoImpl implements AlquilerAccesorioDao {

	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private ServicioAlquiler servicioAlquiler;
	
	@Override
	public void generarAlquilerAccesorio (ArrayList<Accesorio> listAccesorios, Integer idReserva) {
		final Session session = sessionFactory.getCurrentSession();
		for(Accesorio accesorio: listAccesorios) {
			AlquilerAccesorio alquilerAccesorio = new AlquilerAccesorio ();
			alquilerAccesorio.setFkAlquiler(servicioAlquiler.obtenerAlquilerConElIdReserva(idReserva));
		//	alquilerAccesorio.setFkAccesorio(accesorio);
			session.save(alquilerAccesorio);		
				
		}
	}
}
