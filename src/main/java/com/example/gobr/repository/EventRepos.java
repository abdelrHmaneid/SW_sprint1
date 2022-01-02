package com.example.gobr.repository;

import com.example.gobr.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepos extends JpaRepository<Events, Integer> {
}
