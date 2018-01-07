package org.mvc.security.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mvc.security.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * The Class BaseRepositoryImpl.
 *
 * @param <T> the generic type
 */
public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/** The entity. */
	private Class<T> entity;
	
	/** The query. */
	protected Query query;
	
	/** The hql. */
	protected String hql;


	/**
	 * Instantiates a new base repository impl.
	 */
	public BaseRepositoryImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entity = (Class) pt.getActualTypeArguments()[0];
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Gets the current session.
	 *
	 * @return the current session
	 */
	protected Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}

	/* (non-Javadoc)
	 * @see org.mvc.security.repository.BaseRepository#add(java.lang.Object)
	 */
	public void add(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	/* (non-Javadoc)
	 * @see org.mvc.security.repository.BaseRepository#findById(int)
	 */
	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) getCurrentSession().get(entity.getName(), id);
	}

	/* (non-Javadoc)
	 * @see org.mvc.security.repository.BaseRepository#delete(java.lang.Object)
	 */
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}
	
	/* (non-Javadoc)
	 * @see org.mvc.security.repository.BaseRepository#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		query = getCurrentSession().createQuery("from "+entity.getName());
		return query.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see org.mvc.security.repository.BaseRepository#update(java.lang.Object)
	 */
	public void update(T entity){
		getCurrentSession().saveOrUpdate(entity);
		System.out.println("In");
	}
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	@SuppressWarnings("unchecked")
	public void deleteById(Long id) {
		hql = "delete " + entity.getName() + " where id = :id";
		query = getCurrentSession().createQuery(hql).setParameter("id", id);
		query.executeUpdate();
	}

}
