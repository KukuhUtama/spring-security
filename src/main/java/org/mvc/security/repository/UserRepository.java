package org.mvc.security.repository;

import org.mvc.security.entity.User;

/**
 * The Interface UserRepository.
 */
public interface UserRepository {
	 
 	/**
 	 * Load user by username.
 	 *
 	 * @param username the username
 	 * @return the user
 	 */
 	public User loadUserByUsername(String username);
}
