package com.basis.colatina.taskmanager.repository;

import com.basis.colatina.taskmanager.domain.Comment;
import com.basis.colatina.taskmanager.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByTaskId(Integer taskId);
}
