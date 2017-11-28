package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.AlquilerAccesorio;

@Service("alquilerAccesorioDao")
public class AlquilerAccesorioDaoImpl implements AlquilerAccesorioDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void generarAlquilerAccesorio (Accesorio accesorio, Alquiler alquiler) {
		final Session session = sessionFactory.getCurrentSession();
		AlquilerAccesorio alquilerAccesorio = new AlquilerAccesorio();
		alquilerAccesorio.setFkAccesorio(accesorio);
		alquilerAccesorio.setFkAlquiler(alquiler);
		session.save(alquilerAccesorio);
	}
	
}
