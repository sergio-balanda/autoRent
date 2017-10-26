package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public interface  ServicioVehiculo {
	
	public List<Vehiculo> listarVehiculosXPasajeros(Integer cant);
	public Integer maxPasajeros();
	
}
