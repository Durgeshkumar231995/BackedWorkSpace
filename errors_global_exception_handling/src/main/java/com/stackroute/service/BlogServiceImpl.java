package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Blog;
import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;
/* This is ServiceImplementation Class which should implement BlogService Interface and override all the implemented methods.
 * Handle suitable exceptions for all the implemented methods*/

@Service
public class BlogServiceImpl  implements BlogService{
	
	@Autowired
	BlogRepository blogRepository;

	@Override
	public Blog saveBlog(Blog blog) {

		if (blogRepository.existsById(blog.getBlogId())) {
			throw new BlogAlreadyExistsException();
		}
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> getAllBlogs() {
		
		return (List<Blog>) blogRepository.findAll();
	}

	@Override
	public Blog getBlogById(int id) {

		Optional<Blog> findById = blogRepository.findById(id);

		if (findById.isPresent()) {

			return findById.get();

		} else {
			throw new BlogNotFoundException();
		}

	}

	@Override
	public Blog deleteBlog(int id) {

		Optional<Blog> findById = blogRepository.findById(id);

		if (findById.isPresent()) {

			blogRepository.deleteById(id);
			return findById.get();

		} else {
			throw new BlogNotFoundException();
		}

	}

	@Override
	public Blog updateBlog(Blog blog) {

		if (!blogRepository.existsById(blog.getBlogId())) {

			throw new BlogNotFoundException();
		}

		Blog savedBlog = blogRepository.save(blog);

		return savedBlog;

	}

}

