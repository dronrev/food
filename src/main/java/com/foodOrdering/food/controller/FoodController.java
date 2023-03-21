package com.foodOrdering.food.controller;

import com.foodOrdering.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.foodOrdering.food.entity.Food;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class FoodController {

    @Autowired
    private FoodService service;


    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/add_product")
    public String addProduct(){
        return "add_product";
    }

    @GetMapping("/list-of-product")
    public ModelAndView getProdList(){
        List<Food>list=service.getAllProduct();
       // ModelAndView obj = new ModelAndView();
      //  obj.setViewName("list_product");
        //obj.addObject("food",list);
        return new ModelAndView("list_product","food",list);
    }

    @PostMapping("/save")
    public String addingProduct(@ModelAttribute Food food){
        service.save(food);

        return "redirect:/list-of-product";
    }

    @RequestMapping("/edit/{id}")
    public String editFood(@PathVariable("id") int id, Model model){

        Food foodEd = service.getFoodByID(id);
        model.addAttribute("food",foodEd);

        return "edit_product";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteFood(@PathVariable("id") int id){
        service.deleteProd(id);
        return "redirect:/list-of-product";
    }
}
