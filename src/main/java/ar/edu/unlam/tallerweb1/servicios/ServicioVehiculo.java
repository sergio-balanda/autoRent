package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public interface ServicioVehiculo {

	public Vehiculo buscarVehiculos(Integer idVehiculo);

	public List<Vehiculo> listarVehiculosXPasajeros(Integer cant, String sucursal, String fdesde, String fhasta);

	public Integer maxPasajeros();

}
