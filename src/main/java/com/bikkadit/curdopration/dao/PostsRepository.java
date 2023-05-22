package com.bikkadit.curdopration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bikkadit.curdopration.model.Category;
import com.bikkadit.curdopration.model.Posts;
import com.bikkadit.curdopration.model.User;

public interface PostsRepository extends JpaRepository<Posts,Long> {

	List<Posts> findByCategory(Category categoryId);
	
	List<Posts> findByUser(User userId);
	
	@Query("select p from Posts p where p.tital like :key")
	List<Posts> searchByTitl(@Param("key") String tital);
}
