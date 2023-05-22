package com.bikkadit.curdopration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadit.curdopration.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments,Long> {

}
