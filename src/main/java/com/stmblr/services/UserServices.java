package com.stmblr.services;

import com.stmblr.domain.User;

public interface UserServices extends CRUDService<User> {

	User findByUserName(String username);

}
