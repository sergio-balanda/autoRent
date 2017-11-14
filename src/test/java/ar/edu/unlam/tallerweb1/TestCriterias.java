package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public class TestCriterias extends SpringTest {

	@Test
	@Transactional
	@Rollback
	public void test() throws ParseException {

		Vehiculo vUno = new Vehiculo();
		vUno.setIdVehiculo(1);
		vUno.setMarca("Toyota");
		Vehiculo vDos = new Vehiculo();
		vDos.setIdVehiculo(2);
		vDos.setMarca("Toyota");
		Vehiculo vTres = new Vehiculo();
		vTres.setIdVehiculo(3);
		vTres.setMarca("Ford");
		Vehiculo vCuatro = new Vehiculo();
		vCuatro.setIdVehiculo(4);
		vCuatro.setMarca("Ford");

		Reserva r1 = new Reserva();
		r1.setIdReserva(1);
		r1.setFkVehiculoR(vTres);
		r1.setFechaInicio(new Date("03/05/2017"));
		r1.setFechaFin(new Date("04/05/2017"));
		Reserva r2 = new Reserva();
		r2.setIdReserva(2);
		r2.setFkVehiculoR(vCuatro);
		r2.setFechaInicio(new Date("03/11/2017"));
		r2.setFechaFin(new Date("04/11/2017"));

		getSession().save(vUno);
		getSession().save(vDos);
		getSession().save(vTres);
		getSession().save(vCuatro);
		getSession().save(r1);
		getSession().save(r2);

		System.out.println("///////////////////");
		System.out.println(vUno.toString());
		System.out.println("///////////////////");
		System.out.println(r1.toString());
		System.out.println("////////lista//////////");

		Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2017-9-12");
		Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-12");
		getSession().save(d1);
		getSession().save(d2);
		List<Reserva> listaDeReserva = getSession().createCriteria(Reserva.class, "rv")
				.add(Restrictions.between("rv.FechaInicio", d1,d2))
				.createAlias("rv.fkVehiculoR", "vehiculo")
				.list();

		// System.out.println(listaDeReserva.get(0).getIdReserva());
		assertThat(listaDeReserva).hasSize(1);
	}

}
