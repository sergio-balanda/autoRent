package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public interface SucursalDao {

	List<Sucursal> obtenerSucursales();

	Sucursal buscarSucXCiudad(String sucursal);

	Sucursal buscarSucursales(Integer idSucursal);

}