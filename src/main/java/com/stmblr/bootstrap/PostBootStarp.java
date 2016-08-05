package com.stmblr.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.stmblr.domain.Post;
import com.stmblr.domain.User;
import com.stmblr.services.PostServices;
import com.stmblr.services.UserServices;

@Component
public class PostBootStarp implements ApplicationListener<ContextRefreshedEvent> {

	private PostServices postService;

	private UserServices userService;

	@Autowired
	public void setPostService(PostServices postService) {
		this.postService = postService;
	}

	@Autowired
	public void setUserService(UserServices userService) {
		this.userService = userService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-genaerated method stub
		loadPosts();
		loadUsers();

	}

	private void loadPosts() {
		Post post1 = new Post();
		post1.setId(1);
		post1.setTitle("1st Post");
		post1.setDescription("This is my 1st Post");
		post1.setPostUrl("www.example.com/1");
		//post1.setCreateDate();
		postService.saveOrUpdate(post1);

		Post post2 = new Post();
		post2.setId(2);
		post2.setTitle("2nd Post");
		post2.setDescription("This is my 2nd Post");
		post2.setPostUrl("www.example.com/2");
		//post2.setCreateDate();
		postService.saveOrUpdate(post2);
	}

	public void loadUsers() {

		User user1 = new User();
		user1.setName("admin");
		user1.setPassword("admin");

		User user2 = new User();
		user2.setName("user");
		user2.setPassword("123");

		userService.saveOrUpdate(user1);
		userService.saveOrUpdate(user2);
	}

}
