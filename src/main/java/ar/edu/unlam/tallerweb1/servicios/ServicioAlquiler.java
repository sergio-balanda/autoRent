package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Alquiler;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioAlquiler {
	void generarAlquiler(Reserva reserva);

	public Alquiler buscarAlquiler(Integer idAlquiler);

	public Alquiler guardarAlquiler(Integer fkReserva, String estado, Double precioFinal);

}
