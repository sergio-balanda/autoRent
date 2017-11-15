package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("usuarioReservaDao")
public class UsuarioReservaDaoImpl implements UsuarioReservaDao{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Reserva> obtenerReservasDeUnUserPorSuNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
