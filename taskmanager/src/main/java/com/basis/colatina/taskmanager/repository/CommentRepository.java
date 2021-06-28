package com.basis.colatina.taskmanager.repository;

import com.basis.colatina.taskmanager.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
