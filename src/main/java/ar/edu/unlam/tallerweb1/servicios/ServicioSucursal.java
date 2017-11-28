package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;

public interface ServicioSucursal {

	public List<Sucursal> obtenerSucursales();
	/* public Integer buscarSucXCiudad(String sucursal); */
	Sucursal buscarSucursales(Integer idSucursal);
	Sucursal buscarSucXCiudad(String sucursalCiudad);

}
