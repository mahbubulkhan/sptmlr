package com.stmblr.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.stmblr.domain.User;
import com.stmblr.services.security.UserDetailsImpl;


@Component
public  class UserToUserDetails implements Converter<User, UserDetails> {

	@Override
	public UserDetails convert(User user) {
		// TODO Auto-generated method stub
		
		UserDetailsImpl userDetails = new UserDetailsImpl();
		
		if(user!=null)
		{
			userDetails.setUsername(user.getName());
			userDetails.setPassword(user.getEncryptedPassword());
		}
		
		return userDetails;
	}

}
