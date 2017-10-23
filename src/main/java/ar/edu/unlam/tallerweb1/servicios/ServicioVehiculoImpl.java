package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Service("servicioVehiculo")
@Transactional
public class ServicioVehiculoImpl implements ServicioVehiculo{
	@Inject
	private VehiculoDao vehiculoDao;
	@Override
	public List<Vehiculo> listarVehiculos() {
		// TODO Auto-generated method stub
		return vehiculoDao.listarVehiculos();
	}

}
