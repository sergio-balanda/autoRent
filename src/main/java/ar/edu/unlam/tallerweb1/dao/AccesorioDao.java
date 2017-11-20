package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Accesorio;

public interface AccesorioDao {
	Accesorio buscarAccesorios(Integer idAccesorio);

	List<Accesorio> listarAccesorios();

}
