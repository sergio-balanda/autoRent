package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao {

	Usuario consultarUsuario(Usuario usuario);

	Usuario obtenerUsuarioPorId(Integer id);

	void guardarUsuario(Usuario usuario);


}
