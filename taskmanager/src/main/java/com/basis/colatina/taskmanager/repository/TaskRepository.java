package com.basis.colatina.taskmanager.repository;

import com.basis.colatina.taskmanager.domain.Task;
import com.basis.colatina.taskmanager.domain.elastic.TaskDocument;
import com.basis.colatina.taskmanager.repository.elastic.Reindexer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>, Reindexer {
    @Query(value = "SELECT new com.basis.colatina.taskmanager.domain.elastic.TaskDocument( " +
            "t.id, t.title, t.expectedStartDate, t.expectedEndDate, t.startDate, t.endDate, t.status.description, t.owner.name) from Task t where t.id = :id")
    TaskDocument getDocument(@Param("id") Integer id);

    @Override
    default String getEntity() {
        return "task";
    }

    @Override
    @Query(value = "SELECT new com.basis.colatina.taskmanager.domain.elastic.TaskDocument( " +
            "t.id, t.title, t.expectedStartDate, t.expectedEndDate, t.startDate, t.endDate, t.status.description, t.owner.name) from Task t order by t.id")
    Page<TaskDocument> reindexPage(Pageable pageable);
}
