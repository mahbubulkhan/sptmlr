package com.stmblr.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stmblr.config.JpaIntegrationConfig;
import com.stmblr.domain.Post;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
public class PostServiceImplTest {
	
	private PostServices postService;

	@Autowired
	public void setPostService(PostServices postService) {
		this.postService = postService;
	}
	
	
	@Test
	public void testListMethod()
	{
		List<Post> posts = (List<Post>) postService.listAll();
		assert posts.size() == 3;
	}
	
	@Test
	public void testSavePost()
	{
	  Post post = new Post();
	  post.setTitle("test psot");
	  post.setDescription("This is a test posting");
	  post.setPostUrl("www.example.com/test");
	  //post.setCreateDate();
	  Post savedPost = postService.saveOrUpdate(post);
	  assert savedPost.getId() != null;
	  
	}
	
	@Test
	public void testPost()
	{
		Integer id = 1;
		
		Post post = postService.getById(id);
		
		assert post.getId()!= null;
	}
	
	@Test
	public void testDeletePost()
	{
		Integer id = 1;
		
		postService.delete(id);
		
		List<Post> posts = (List<Post>) postService.listAll();
		assert posts.size() == 2;
		
		
	}

}
