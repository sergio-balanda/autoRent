package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface AlquilerDao {
	
	void generarAlquiler (Reserva reserva);
	
	//mio, no querias hacer alquiler, buen yo lo dejo con alquiler
	void guardarAlquiler(Alquiler alquiler);

	Alquiler buscarAlquiler(Integer idAlquiler);

}
