package com.stmblr.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stmblr.config.JpaIntegrationConfig;

import com.stmblr.domain.User;





@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
public class UserServiceImplTest {
	
	private UserServices userService;

	@Autowired
	public void setUserService(UserServices userService) {
		this.userService = userService;
	}
	
		
	 @Test
	 public void testSaveOfUser() throws Exception {
	        User user = new User();

	        user.setName("someusername");
	        user.setPassword("myPassword");

	        User savedUser = userService.saveOrUpdate(user);

	        assert savedUser.getId() != null;
	        assert savedUser.getEncryptedPassword() != null;

	        System.out.println("Encrypted Password");
	        System.out.println(savedUser.getEncryptedPassword());

	 }
	 
	 @Test
	 public void testListofUsers()
	 {
		List<User> users = (List<User>) userService.listAll();
		
		assert users.size() == 3;
	 }
	 
	 @Test
	 public void testUser()
	 {
		 Integer id = 1;
		 
		 User user = userService.getById(id);
		 
		 assert user.getId() != null;
	 }
	 
	 @Test
	 public void deleteUser()
	 {
		 Integer id = 1;
		 userService.delete(id);
		 
		 List<User> users = (List<User>) userService.listAll();
			
	     assert users.size() == 2;
	 }

}
