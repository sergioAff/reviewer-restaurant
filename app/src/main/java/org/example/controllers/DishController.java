package org.example.controllers;

import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.services.DishService;

import java.util.List;

public class DishController  {
  private final DishService dishService;


  public DishController() {
    this.dishService = new DishService();

  }

  public void createDish(String name, String description, double price) {
    dishService.createDish(name, description, price);
  }

  public List<DishModel> getAllDishes() {
    return dishService.getAllDishes();
  }

  public void updateDish(String name, String newDescription, double newPrice) {
    dishService.updateDish(name, newDescription, newPrice);

  }

  public void deleteDish(String name) {
    dishService.deleteDish(name);

  }

  public void addReviewToDish(String dishName, String reviewerName, int rating, String comment) {
    dishService.addReviewToDish(dishName, reviewerName, rating, comment);

  }

  public List<DishReviewModel> getReviewsOfDish(String dishName) {
    return dishService.getReviewsOfDish(dishName);
  }

  public double getAverageRatingOfDish(String dishName) {
    return dishService.getAverageRatingOfDish(dishName);
  }

}
