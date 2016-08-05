package com.stmblr.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stmblr.domain.Post;
import com.stmblr.services.PostServices;



@Controller
public class PostController {
	
	private PostServices postService;
	
    @Autowired
	public void setPostService(PostServices postService) {
		this.postService = postService;
	}
	
	    
    @RequestMapping("/post")
    public String listPosts(Model model){

        model.addAttribute("posts", postService.listAll());

        return "posts";
    }
    
    
    @RequestMapping("/post/{id}")
    public String getPost(@PathVariable Integer id, Model model){

        model.addAttribute("post", postService.getById(id));

        return "post";
    }
    
    @RequestMapping("/post/new")
    public String newPost(Model model){
        model.addAttribute("post", new Post());
        return "postform";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String saveOrUpdatePost(@Valid Post post,BindingResult result){
    	if(result.hasErrors())
    	{
    		return "postform";
    	}
        Post savedPost = postService.saveOrUpdate(post);
        //savedPost.setCreateDate();
        return "redirect:/post/" + savedPost.getId();
    }
    
    
    @RequestMapping("/post/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("post", postService.getById(id));
        return "postform";
    }
    
    
    @RequestMapping("/post/delete/{id}")
    public String delete(@PathVariable Integer id){
        postService.delete(id);

        return "redirect:/post";
    }


}
