package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	// Como todo dao maneja acciones de persistencia
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		// Se obtiene la sesion asociada a la transaccion iniciada en el
		// servicio que
		// invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los
		// del
		// objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la
		// busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword())).uniqueResult();
	}

	@Override
	public Usuario obtenerUsuarioPorId(Integer id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarUsuarios() {
		final Session session = sessionFactory.getCurrentSession();
		List<Usuario> usuarios = session.createCriteria(Usuario.class, "U")
				.addOrder(Order.desc("U.administrador"))
				.list();
		return usuarios;
	}

}// fin
