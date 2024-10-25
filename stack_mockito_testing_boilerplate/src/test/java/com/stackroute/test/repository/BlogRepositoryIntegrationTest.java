package com.stackroute.test.repository;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BlogRepositoryIntegrationTest {

    @Autowired
    private BlogRepository blogRepository;
    private Blog blog;

    @BeforeEach
    public void setUp() {
        blog = new Blog();
        blog.setBlogId(1);
        blog.setBlogTitle("Blog1");
        blog.setAuthorName("Imneet");
        blog.setBlogContent("Sample content");
    }
    @AfterEach
    public void tearDown() {
        blogRepository.deleteAll();
        blog = null;
    }

    /*
    * Test for saving a blog in database: blogRepository.save(blog) method
     */
    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() {
    	Blog save = blogRepository.save(blog);
    	Blog existingBlog = blogRepository.findById(1).get();
    	assertEquals(save.getAuthorName(),existingBlog.getAuthorName());
    	  assertEquals(1, existingBlog.getBlogId());
    }


    /*
    * Test for getting all blogs: blogRepository.findAll() method
     */
    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() {
    	
    	 blogRepository.save(blog);
         List<Blog> blogList = (List<Blog>) blogRepository.findAll();
         assertEquals("Blog1", blogList.get(0).getBlogTitle());
    }

    /*
    * Test for getting a blog by id: blogRepository.findById(blogId) method
     */
    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() {
    	
    	Blog blog1 = blogRepository.save(blog);
        Optional<Blog> optional = blogRepository.findById(blog1.getBlogId());
        assertEquals(blog1.getBlogId(), optional.get().getBlogId());
        assertEquals(blog1.getBlogTitle(), optional.get().getBlogTitle());
        assertEquals(blog1.getAuthorName(), optional.get().getAuthorName());
        assertEquals(blog1.getBlogContent(), optional.get().getBlogContent());
    }

    /*
    * Test for deleting a blog by id: blogRepository.deleteById(blogId) method
     */
    @Test
    public void givenBlogIdToDeleteThenShouldReturnDeletedBlog() {
    	
    	blogRepository.save(blog);
        blogRepository.deleteById(blog.getBlogId());
        Optional optional = blogRepository.findById(blog.getBlogId());
        assertEquals(Optional.empty(), optional);
    }

}