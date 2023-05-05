package com.stanimalis.springboot.nycsummerbaseball.service;

import com.stanimalis.springboot.nycsummerbaseball.entity.Batter;

import java.util.List;

public interface BatterService {

    List<Batter> findAll();

    Batter findById(int theId);

    Batter save(Batter theBatter);

    void deleteById(int theId);

}
