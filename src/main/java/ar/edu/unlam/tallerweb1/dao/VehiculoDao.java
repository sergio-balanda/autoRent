package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public interface VehiculoDao {
	
	List<Vehiculo> listarVehiculosXPasajeros(Integer cant, String sucursal);
	Integer maxPasajeros();
	List<Sucursal> obtenerSucursales(List<Sucursal> lista);
}
