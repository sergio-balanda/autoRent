package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Accesorio;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioAccesorio {
	
	public Accesorio buscarAccesorios(Integer idAccesorio);
	public List<Accesorio> listarAccesorios();
	public Double calcularPrecioPorAccesorios (ArrayList<Integer> accesorios, Long cantidadDeDias);
	public List<Accesorio> buscarAccesoriosPorAlquiler(Integer idAlquiler);
	
}
