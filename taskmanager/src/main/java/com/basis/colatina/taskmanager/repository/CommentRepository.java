package com.basis.colatina.taskmanager.repository;

import com.basis.colatina.taskmanager.domain.Comment;
import com.basis.colatina.taskmanager.domain.elastic.CommentDocument;
import com.basis.colatina.taskmanager.repository.elastic.Reindexer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>, Reindexer {
    List<Comment> findAllByTaskId(Integer taskId);

    @Query(value = "select new com.basis.colatina.taskmanager.domain.elastic.CommentDocument( " +
            "c.id, c.description, c.task.title, c.owner.name) from Comment c where c.id = :id")
    CommentDocument getDocument(@Param("id") Integer id);

    @Override
    default String getEntity() {
        return "comment";
    };

    @Override
    @Query(value = "select new com.basis.colatina.taskmanager.domain.elastic.CommentDocument( " +
            "c.id, c.description, c.task.title, c.owner.name) from Comment c order by c.id")
    Page<CommentDocument> reindexPage(Pageable pageable);
}
