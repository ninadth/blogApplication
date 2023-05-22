package com.bikkadit.curdopration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.curdopration.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
