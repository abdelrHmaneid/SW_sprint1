package com.example.gobr.repository;

import com.example.gobr.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<UserProfile,String> {

}
