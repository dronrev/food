package com.foodOrdering.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodOrdering.food.entity.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepo extends JpaRepository<Food,Integer> {

}
