package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("reservaDao")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ReservaDaoImpl implements ReservaDao {

	@Inject
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void guardarReserva(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(reserva);
	}

	@Override
	public Reserva buscarReservas(Integer idReserva) {
		final Session session = sessionFactory.getCurrentSession();
		Reserva reserva = (Reserva) session.createCriteria(Reserva.class).add(Restrictions.eq("idReserva", idReserva))
				.uniqueResult();
		return reserva;
	}

	@Override
	public List<Reserva> listarReservas() {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Reserva.class).list();
	}
	@Override
	/*public Integer guardarFecha(Integer idReserva,String fechaFinReserva){
		final Session session = sessionFactory.getCurrentSession();
		// CAST de String To Date
				DateFormat fechaFinReservaFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				Date dateFinReserva = new Date();
				try {
					dateFinReserva = fechaFinReservaFormat.parse(fechaFinReserva);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// -----------FIN CAST
		List resultado = session.createCriteria(Reserva.class)
						  .add(Restrictions.eq("idReserva",idReserva))
						  .list();
		reserva.setFechaFin(dateFinReserva);
		session.update(reserva);
		// ver calculo de dias
		return 1; 

		
	}*/
	
	public Integer guardarFecha(Reserva reserva){
		final Session session = sessionFactory.getCurrentSession();
		session.update(reserva);
		// ver calculo de dias
		return 1; 

		
	}

}