package com.basis.colatina.taskmanager.repository;

import com.basis.colatina.taskmanager.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
