package com.basis.colatina.taskmanager.repository;

import com.basis.colatina.taskmanager.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
