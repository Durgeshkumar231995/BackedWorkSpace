package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
    private BlogRepository blogRepository;

    /**
     * Constructor based Dependency injection to inject BlogRepository here
     */
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * save a new blog
     */

	@Override
	public Blog saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogRepository.save(blog);
	}

	 /**
     * retrieve all blogs
     */

	@Override
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return (List<Blog>) blogRepository.findAll();
	}

	  /**
     * retrieve blog by id
     */
		@Override
		public Blog getBlogById(int id) {
			// TODO Auto-generated method stub
			Optional<Blog> existId = blogRepository.findById(id);

			if (existId.isPresent()) {
				existId.get();
			}
			return null;
		}

	 /**
     * delete blog by id
     */

		@Override
		public Blog deleteBlog(int id) {
			// TODO Auto-generated method stub
			Optional<Blog> existBlogId = blogRepository.findById(id);
			if (existBlogId.isPresent()) {
				blogRepository.deleteById(id);
				 return existBlogId.get();
			}
			return null;
		}

	 /**
     * update blog
     */
		@Override
		public Blog updateBlog(Blog blog) {
			if (blogRepository.findById(blog.getBlogId()).isEmpty()) {
				return null;
			} else {
				Optional<Blog> existBlog = blogRepository.findById(blog.getBlogId());
				if (existBlog.isPresent()) {
					Blog updatedBlog = blogRepository.save(blog);
					 return updatedBlog;
				}
			}

			return null;
		}

}

