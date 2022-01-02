package com.example.gobr.repository;

import com.example.gobr.models.DriverProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepos extends JpaRepository<DriverProfile,String> {

}
