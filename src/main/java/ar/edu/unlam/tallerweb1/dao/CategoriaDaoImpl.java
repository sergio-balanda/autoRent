package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Categoria;

@Service("categoriaDao")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class CategoriaDaoImpl implements CategoriaDao{

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		final Session s = sessionFactory.getCurrentSession();
		Categoria cat = (Categoria) s.createCriteria(Categoria.class)
				.add(Restrictions.eq("idCategoria", idCategoria)).uniqueResult();
		return cat;
	}
	
}