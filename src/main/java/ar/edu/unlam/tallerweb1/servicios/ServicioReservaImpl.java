package ar.edu.unlam.tallerweb1.servicios;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioComic")
@Transactional
public class ServicioReservaImpl implements ServicioReserva {
	
	
	@Override
	public void guardarReserva(Integer idVehiculo, String sucursal , String fdsd , String fhst) {
	}

}