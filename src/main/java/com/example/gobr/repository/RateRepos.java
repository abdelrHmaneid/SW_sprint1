package com.example.gobr.repository;

import com.example.gobr.models.Rates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RateRepos extends JpaRepository<Rates,String> {
}
