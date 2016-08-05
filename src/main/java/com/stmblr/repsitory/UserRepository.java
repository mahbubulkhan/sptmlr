package com.stmblr.repsitory;

import org.springframework.data.repository.CrudRepository;
import com.stmblr.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	 User findByName(String username);
	
	
}
