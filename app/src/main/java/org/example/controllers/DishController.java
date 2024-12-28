package org.example.controllers;

import org.example.models.DishModel;
import org.example.services.DishService;

import java.util.List;

public class DishController  {
  private final DishService dishService;


  public DishController() {
    this.dishService = new DishService();

  }

  public void createDish(String name, String description, Double price) {
    dishService.createDish(name, description, price);
  }

  public List<DishModel> getAllDishes(String name) {
    return dishService.getAllDishes(name);
  }

  public void updateDish(String name, String newDescription, Double newPrice) {
    dishService.updateDish(name, newDescription, newPrice);

  }

  public Double getAverageRatingOfDish(String dishName) {
    return dishService.getAverageRatingOfDish(dishName);
  }

}
