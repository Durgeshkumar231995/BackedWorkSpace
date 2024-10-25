package com.stackroute.controller;

import java.util.List;
/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import com.stackroute.service.BlogServiceImpl;

/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RestController
@RequestMapping("/api/v1")
public class BlogController {

	@Autowired
    private BlogService blogService;


    /**
     * save a new blog
     */
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
    	
    	Blog saveBlog = blogService.saveBlog(blog);
    	
    	return new ResponseEntity<Blog>(saveBlog,HttpStatus.CREATED);
    }

    /**
     * retrieve all blogs
     */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
    	
    	return new ResponseEntity<>(blogService.getAllBlogs(),HttpStatus.OK);
		
    }

    /**
     * retrieve blog by id
     */
    @GetMapping("blog/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") int blogId) {
    	Blog blogById = blogService.getBlogById(blogId);
    	return new ResponseEntity<>(blogById,HttpStatus.OK);
    }

    /**
     * delete blog by id
     */
	@DeleteMapping("blog/{blogId}")
	public ResponseEntity<?> getBlogAfterDeleting(@PathVariable("blogId") int blogId) {
		
		blogService.deleteBlog(blogId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}


	/**
	 * update blog
	 */
	@PutMapping("blog")
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {

		return new ResponseEntity<>(blogService.saveBlog(blog), HttpStatus.OK);

	}
}