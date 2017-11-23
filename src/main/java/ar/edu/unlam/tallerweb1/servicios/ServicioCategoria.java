package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Categoria;

public interface ServicioCategoria {
	
	Categoria buscarPorId(Integer idCategoria);
	public float calcularCostoOrigen(String fDesde, String fHasta, Integer idVehiculo);
	float verCostoDiario(Integer idVehiculo);
	
}