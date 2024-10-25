package com.stackroute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.domain.Blog;

/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer> {
}
