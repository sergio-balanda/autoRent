package ar.edu.unlam.tallerweb1.dao;


import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public interface VehiculoDao {
	
	Vehiculo buscarVehiculos(Integer idVehiculo);
	List<Vehiculo> listarVehiculosXPasajeros(Integer cantidadPasajeros, String sucursal, String fechaDesde , String fechaHasta );
	Integer maxPasajeros();

}
