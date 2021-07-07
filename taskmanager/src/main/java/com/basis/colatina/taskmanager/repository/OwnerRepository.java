package com.basis.colatina.taskmanager.repository;

import com.basis.colatina.taskmanager.domain.Owner;
import com.basis.colatina.taskmanager.domain.elastic.OwnerDocument;
import com.basis.colatina.taskmanager.repository.elastic.Reindexer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>, Reindexer {

    @Query(value = "select new com.basis.colatina.taskmanager.domain.elastic.OwnerDocument( " +
            " o.id, o.name, o.email, o.birthDate, o.status.description) from Owner o where o.id = :id")
    OwnerDocument getDocument(@Param("id") Integer id);

    @Override
    default String getEntity() {
        return "owner";
    }

    @Override
    @Query(value = "select new com.basis.colatina.taskmanager.domain.elastic.OwnerDocument( " +
            " o.id, o.name, o.email, o.birthDate, o.status.description) from Owner o order by o.id")
    Page<OwnerDocument> reindexPage(Pageable pageable);
}
