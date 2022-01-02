package com.example.gobr.repository;

import com.example.gobr.models.Rides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepos extends JpaRepository<Rides, Integer> {
}
