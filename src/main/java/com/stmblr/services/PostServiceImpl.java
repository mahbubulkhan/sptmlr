package com.stmblr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stmblr.domain.Post;
import com.stmblr.repsitory.PostRepository;

@Service
public class PostServiceImpl  implements PostServices //extends AbstractMapService
{
     
	private PostRepository postRepository;
	
	@Autowired
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	
	@Override
	public List<?> listAll() {
		// TODO Auto-generated method stub
		List<Post> posts = new ArrayList<>();
		postRepository.findAll().forEach(posts::add);
		return posts;
	}

	@Override
	public Post getById(Integer id) {
		// TODO Auto-generated method stub
		return postRepository.findOne(id);
	}

	@Override
	public Post saveOrUpdate(Post domainObject) {
		// TODO Auto-generated method stub
		//domainObject.setCreateDate();
		return postRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
		postRepository.delete(id);
		
	}

	
	
	/*@Override
	public List<DomainObject> listAll() {
		// TODO Auto-generated method stub
		return super.listAll();
	}

	@Override
	public Post getById(Integer id) {
		// TODO Auto-generated method stub
		return (Post) super.getById(id);
	}

	@Override
	public Post saveOrUpdate(Post domainObject) {
		// TODO Auto-generated method stub
		return (Post) super.saveOrUpdate(domainObject);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		super.delete(id);
	}

	@Override
	protected void loadDomainObjects() {
		// TODO Auto-generated method stub
		
		domainMap = new HashMap<>();
		
		Post post1 = new Post();
		post1.setId(1);
		post1.setTitle("1st Post");
		post1.setDescription("This is my 1st Post");
		post1.setPostUrl("www.example.com/1");
		post1.setCreateDate();
		domainMap.put(1, post1);
		
		Post post2 = new Post();
		post2.setId(2);
		post2.setTitle("2nd Post");
		post2.setDescription("This is my 2nd Post");
		post2.setPostUrl("www.example.com/2");
		post2.setCreateDate();
		
		domainMap.put(2, post2);
		
	}

	*/
	

}
