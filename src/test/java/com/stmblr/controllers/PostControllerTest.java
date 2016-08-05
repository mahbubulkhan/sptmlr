package com.stmblr.controllers;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stmblr.domain.Post;
import com.stmblr.services.PostServices;


public class PostControllerTest {

	@Mock
	private PostServices postService;

	@InjectMocks
	private PostController postController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this); // initilizes controller and mocks

		mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
	}

	@Test
	public void testPosts() throws Exception {

		List<Post> posts = new ArrayList<>();
		posts.add(new Post());
		posts.add(new Post());

		// specific Mockito interaction, tell stub to return list of products
		when(postService.listAll()).thenReturn((List) posts); // need to
																// strip
																// generics
																// to keep
																// Mockito
																// happy.

		mockMvc.perform(get("/post")).andExpect(status().isOk()).andExpect(view().name("posts"))
				.andExpect(model().attribute("posts", hasSize(2)));
	}

	@Test
	public void testShow() throws Exception {
		Integer id = 1;

		// Tell Mockito stub to return new product for ID 1
		when(postService.getById(id)).thenReturn(new Post());

		mockMvc.perform(get("/post/1")).andExpect(status().isOk()).andExpect(view().name("post"))
				.andExpect(model().attribute("post", instanceOf(Post.class)));
	}

	@Test
	public void testEdit() throws Exception {
		Integer id = 1;

		// Tell Mockito stub to return new product for ID 1
		when(postService.getById(id)).thenReturn(new Post());

		mockMvc.perform(get("/post/edit/1")).andExpect(status().isOk()).andExpect(view().name("postform"))
				.andExpect(model().attribute("post", instanceOf(Post.class)));
	}
	
	@Test
    public void testNewPost() throws Exception {
        
  
        verifyZeroInteractions(postService);

        mockMvc.perform(get("/post/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("postform"))
                .andExpect(model().attribute("post", instanceOf(Post.class)));
    }
	
	@Test
	public void testSaveOrUpdatePost() throws Exception
	{
		Integer id =1;
		String title = "Test";
		String description = "This is a test Post";
		String url = "www.example.com";
		
		Post returnpost = new Post();
		returnpost.setId(id);
		returnpost.setTitle(title);
		returnpost.setDescription(description);
		returnpost.setPostUrl(url);
		
		 when(postService.saveOrUpdate(Matchers.<Post>any())).thenReturn(returnpost);
		 
		 
		 mockMvc.perform(post("/post")
			        .param("id", "1")
			        .param("title", title)
			        .param("description", description)
			        .param("postUrl", "www.example.com"))
			                .andExpect(status().is3xxRedirection())
			                .andExpect(view().name("redirect:/post/1"))
			                .andExpect(model().attribute("post", instanceOf(Post.class)))
			                .andExpect(model().attribute("post", hasProperty("id", is(id))))
			                .andExpect(model().attribute("post", hasProperty("description", is(description))))
			                .andExpect(model().attribute("post", hasProperty("title", is(title))))
			                .andExpect(model().attribute("post", hasProperty("postUrl", is(url))));
	}
	
	
	@Test
    public void testDeletePost() throws Exception{
        Integer id = 1;

        mockMvc.perform(get("/post/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/post"));

        verify(postService, times(1)).delete(id);
    }

}
