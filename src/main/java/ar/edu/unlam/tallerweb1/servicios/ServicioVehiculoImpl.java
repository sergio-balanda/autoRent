package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Service("servicioVehiculo")
@Transactional
public class ServicioVehiculoImpl implements ServicioVehiculo{
	
	@Inject
	private VehiculoDao vehiculoDao;
	
	@Override
	public List<Vehiculo> listarVehiculosXPasajeros(Integer cant, String sucursal) {
		return vehiculoDao.listarVehiculosXPasajeros(cant, sucursal);
	}

	@Override
	public Integer maxPasajeros() {
		return vehiculoDao.maxPasajeros();
	}
	@Override
	public List<Sucursal> obtenerSucursales(List<Sucursal> lista) {
		return vehiculoDao.obtenerSucursales(lista);
	}
}