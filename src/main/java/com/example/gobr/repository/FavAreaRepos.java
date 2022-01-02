package com.example.gobr.repository;


import com.example.gobr.models.FavArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavAreaRepos extends JpaRepository<FavArea, String>{
}
