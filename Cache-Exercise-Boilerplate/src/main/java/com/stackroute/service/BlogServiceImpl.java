package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/*
    Add annotation to define cache configuration
*/

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
    private BlogRepository blogRepository;

	@PersistenceContext
    private EntityManager entityManager;


    /*
        Add annotation to update the value of the cache
    */

    /**
     * Implementation of saveBlog method
     */
   
	@Transactional
    @CacheEvict(value = "blogs", allEntries = true)
    @Override
    public Blog saveBlog(Blog blog) {
         Blog saveBlog = blogRepository.save(blog);
         entityManager.flush();
         entityManager.clear();
         return saveBlog;
    }


    /*
        Add annotation to cache the result of this method
    */

    /**
     * Implementation of getAllBlogs method
     */
 
	 @Cacheable(value = "blogs")
    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    /*
        Add annotation to cache the result of this method
    */

    /**
     * Implementation of getBlogById method
     */
   
	 @Transactional
	 @Cacheable(value = "blogs", key = "#blogId")
    @Override
    public Blog getBlogById(int blogId) {
        Blog retrievedBlog = null;
        retrievedBlog = blogRepository.findById(blogId).get();
        return retrievedBlog;
        
    }

    /*
        Add annotation to remove data from from the cache
    */

    /**
     * Implementation of deleteBlogById method
     */
   
	@Transactional
	@CacheEvict(value = "blogs", key = "#blogId", allEntries = true)
	@Override
	public Blog deleteBlogById(int blogId) {
		Blog blog = null;
		Optional optional = blogRepository.findById(blogId);
		if (optional.isPresent()) {
			blog = blogRepository.findById(blogId).get();
			blogRepository.deleteById(blogId);
		}
		return blog;
	}

    /*
        Add annotation to update the cache with the result of the method execution
    */

    /**
     * Implementation of updateBlog method
     */
    
   
    @Transactional
    @CacheEvict(value = "blogs",key = "#blog.blogId" ,allEntries = true)
    @Override
    public Blog updateBlog(Blog blog) {
        Blog updatedBlog = null;
        Optional optional = blogRepository.findById(blog.getBlogId());
        if (optional.isPresent()) {
            Blog getBlog = blogRepository.findById(blog.getBlogId()).get();
            getBlog.setBlogTitle(blog.getBlogTitle());
            getBlog.setAuthorName(blog.getAuthorName());
            getBlog.setBlogContent(blog.getBlogContent());
            entityManager.flush();
            entityManager.clear();
            updatedBlog = saveBlog(getBlog);
        }
        return updatedBlog;

    }

}
