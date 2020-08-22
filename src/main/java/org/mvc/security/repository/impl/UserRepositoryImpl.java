package org.mvc.security.repository.impl;

import java.util.List;

import org.mvc.security.entity.User;
import org.mvc.security.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * The Class UserRepositoryImpl.
 */
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User>  implements UserRepository{


	@Override
	public User loadUserByUsername(String username) {
		query = getCurrentSession().createQuery("select u FROM User u where u.username = :username");
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        if (users != null && users.size() == 1) {
            return users.get(0);
        }
       return null;
	}
	
}
