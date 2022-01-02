package com.example.gobr.service;

import com.example.gobr.models.FavArea;
import com.example.gobr.repository.FavAreaRepos;
import org.springframework.stereotype.Service;

@Service
public class AddFavAreaService {
    FavAreaRepos favAreaRepos;

    public AddFavAreaService(FavAreaRepos favAreaRepos) {
        this.favAreaRepos = favAreaRepos;
    }

    public void Add(FavArea favArea){
        favAreaRepos.save(favArea);
    }
}
