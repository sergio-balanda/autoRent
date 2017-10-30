package ar.edu.unlam.tallerweb1.dao;


import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public interface VehiculoDao {
	
	Vehiculo buscarVehiculos(Integer idVehiculo);
	List<Vehiculo> listarVehiculosXPasajeros(Integer cant, String sucursal, String fdesde , String fhasta );
	Integer maxPasajeros();

}
