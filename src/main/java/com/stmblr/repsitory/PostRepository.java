package com.stmblr.repsitory;

import org.springframework.data.repository.CrudRepository;

import com.stmblr.domain.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
