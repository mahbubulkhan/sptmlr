package com.stmblr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stmblr.domain.User;
import com.stmblr.repsitory.UserRepository;
import com.stmblr.services.security.EncryptionService;


@Service
public class UserServiceImpl implements UserServices{
	
	private UserRepository userRepository;
	private EncryptionService encryptionService;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	@Override
	public List<?> listAll() {
		// TODO Auto-generated method stub
		
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public User saveOrUpdate(User domainObject) {
		// TODO Auto-generated method stub
		if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
        return userRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByName(username);
	}

	
}
