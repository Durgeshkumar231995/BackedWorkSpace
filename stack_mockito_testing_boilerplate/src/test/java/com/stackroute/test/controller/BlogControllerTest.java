package com.stackroute.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.controller.BlogController;
import com.stackroute.domain.Blog;
import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
import com.stackroute.service.BlogService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class BlogControllerTest {

    private MockMvc mockMvc;

    // Mock BlogService layer
    @Mock
    BlogService blogService;

    // Inject BlogService into BlogController
    @InjectMocks
    BlogController blogController;

    private Blog blog;
    private List<Blog> blogList;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
        blog = new Blog();
        blog.setBlogId(1);
        blog.setBlogTitle("DemoBlog");
        blog.setAuthorName("Imneet");
        blog.setBlogContent("SampleBlogforTesting");
        blogList = new ArrayList<>();
        blogList.add(blog);
    }

    @AfterEach
    public void tearDown() {
        blog = null;
    }

    /*
     * Test - POST mapping "/api/v1/blog" to save a blog, by mocking service class
     */
    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() throws Exception {
    	
    	when(blogService.saveBlog(any())).thenReturn(blog);
        mockMvc.perform(post("/api/v1/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(blog)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    /*
     * Test - GET mapping "/api/v1/blogs" to get all blogs, by mocking service class
     */
	@Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() throws Exception {
    	
    	 when(blogService.getAllBlogs()).thenReturn(blogList);
         mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/blogs")
                 .contentType(MediaType.APPLICATION_JSON).content(asJsonString(blog)))
                 .andDo(MockMvcResultHandlers.print());
         verify(blogService).getAllBlogs();
         verify(blogService, times(1)).getAllBlogs();
    }

    /*
     * Test - GET mapping "/api/v1/blog/1" to get a blog by id, by mocking service class
     */
    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() throws Exception {
    	
    	 when(blogService.getBlogById(blog.getBlogId())).thenReturn(blog);
         mockMvc.perform(get("/api/v1/blog/1")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(asJsonString(blog)))
                 .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());

    }

    /*
     * Test - DELETE mapping "/api/v1/blog/1" to delete a blog by id, by mocking service class
     */
    @Test
    public void givenBlogIdToDeleteThenShouldNotReturnDeletedBlog() throws Exception {
    	 when(blogService.deleteBlog(blog.getBlogId())).thenReturn(blog);
         mockMvc.perform(delete("/api/v1/blog/1")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(asJsonString(blog)))
                 .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /*
     * Test - PUT mapping "/api/v1/blog" to update a blog, by mocking service class
     */
    @Test
    public void givenBlogToUpdateThenShouldReturnUpdatedBlog() throws Exception {
    	 when(blogService.updateBlog(any())).thenReturn(blog);
         mockMvc.perform(put("/api/v1/blog").contentType(MediaType.APPLICATION_JSON).content(asJsonString(blog)))
                 .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /*
     * Test - GET mapping "/api/v1/blog/2" to get a blog by id, by mocking service class
     * throw BlogNotFoundException and Expect string "Blog not found with id: 2"
     */
    @Test
    public void givenBlogIdNotFoundThenShouldReturnNotFound() throws Exception {
    	
        Mockito.when(blogService.getBlogById(blog.getBlogId()))
               .thenThrow(new BlogNotFoundException("Blog not found with id: " +  blog.getBlogId()));

       
        mockMvc.perform(get("/api/v1/blog/{id}", blog.getBlogId()))
               .andExpect(status().isNotFound())
               .andExpect(content().string("Blog not found with id: " +  blog.getBlogId()));
    }

    /*
     * Test - GET mapping "/api/v1/blog/1" to get a blog by id, by mocking service class
     * throw RuntimeException and Expect string "An error occurred: Some error"
     */
    @Test
    public void givenBlogServiceThrowsExceptionThenShouldReturnInternalServerError() throws Exception {
    	
    	 Mockito.when(blogService.getBlogById(1)).thenThrow(new RuntimeException("Some error"));

        
         mockMvc.perform(get("/api/v1/blog/{id}", 1))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An error occurred: Some error"));
    }

    /*
     * Test - POST mapping "/api/v1/blog" to save a blog, by mocking service class
     * throw BlogAlreadyExistsException and Expect string "Blog with ID 1 already exists"
     */
	@Test
	public void givenBlogAlreadyExistsThenShouldReturnConflict() throws Exception {

		Mockito.doThrow(new BlogAlreadyExistsException("Blog with ID 1 already exists")).when(blogService)
				.saveBlog(Mockito.any(Blog.class));

		mockMvc.perform(post("/api/v1/blog").contentType(MediaType.APPLICATION_JSON).content(asJsonString(blog)))
				.andExpect(status().isConflict())
				.andExpect(content().string("Blog with ID 1 already exists"));

	}

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}