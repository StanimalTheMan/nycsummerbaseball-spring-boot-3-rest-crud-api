package com.stanimalis.springboot.nycsummerbaseball.dao;

import com.stanimalis.springboot.nycsummerbaseball.entity.Batter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatterRepository extends JpaRepository<Batter, Integer> {

}
