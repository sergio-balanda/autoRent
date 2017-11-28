package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private UsuarioDao usuarioDao;

	@Override
	public Usuario guardarUsuario(Integer id, String email, String password, Boolean administrador, String cuit,
			Integer puntos, String nombre) {
		Usuario usuario = null;

		if (id != null) {
			usuario = usuarioDao.obtenerUsuarioPorId(id);
		} else {
			usuario = new Usuario();
		}

		usuario.setEmail(email.toLowerCase());
		usuario.setPassword(password);
		usuario.setCuit(cuit);
		usuario.setAdministrador(administrador);
		usuario.setPuntos(0);
		usuario.setNombre(nombre);
		usuarioDao.guardarUsuario(usuario);
		return usuario;
	}

	@Override
	public Usuario obtenerUsuarioPorId(Integer id) {
		return usuarioDao.obtenerUsuarioPorId(id);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDao.listarUsuarios();
	}

}// FIN