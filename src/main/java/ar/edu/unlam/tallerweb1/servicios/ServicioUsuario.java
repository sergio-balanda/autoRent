package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	Usuario guardarUsuario(Integer id, String email, String password, Boolean administrador, String cuit,
			Integer puntos, String nombre);
	Usuario obtenerUsuarioPorId(Integer id);
	List<Usuario> listarUsuarios();

}
