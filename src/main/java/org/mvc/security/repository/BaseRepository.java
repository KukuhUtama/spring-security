package org.mvc.security.repository;

import java.util.List;

/**
 * The Interface BaseRepository.
 *
 * @param <T> the generic type
 */
public interface BaseRepository <T> {
	
	/**
	 * Adds the.
	 *
	 * @param entity the entity
	 */
	public void add(T entity);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T findById(Long id);
	
	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public void delete(T entity);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<T> findAll();
	
	/**
	 * Update.
	 *
	 * @param entity the entity
	 */
	public void update(T entity);
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	public void deleteById(Long id);
}
