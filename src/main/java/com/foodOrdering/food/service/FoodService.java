package com.foodOrdering.food.service;

import com.foodOrdering.food.entity.Food;
import com.foodOrdering.food.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;
    public void save(Food food){
        foodRepo.save(food);
    }

    public List<Food> getAllProduct(){
        return foodRepo.findAll();
    }

    public void deleteProd(int id){
        foodRepo.deleteById(id);
    }

    public Food getFoodByID(int id){
        return foodRepo.findById(id).get();
    }

}
