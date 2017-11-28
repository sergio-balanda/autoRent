package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Categoria;

public interface CategoriaDao {

	Categoria buscarPorId(Integer idCategoria);

	float calcularCostoOrigen(String fechaDesde, String fechaHasta, Integer idVehiculo);

	float verCostoDiario(Integer idVehiculo);

}
