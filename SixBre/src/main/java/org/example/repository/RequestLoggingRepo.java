package org.example.repository;

import org.example.model.RequestLogging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLoggingRepo extends JpaRepository<RequestLogging,Integer> {
}
