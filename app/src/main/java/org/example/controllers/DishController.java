package org.example.controllers;

import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.observable.Observable;
import org.example.observable.Observer;
import org.example.services.DishService;

import java.util.ArrayList;
import java.util.List;

public class DishController implements Observable {
  private final DishService dishService;
  private final List<Observer> observers;

  public DishController() {
    this.dishService = new DishService();
    this.observers = new ArrayList<>();
  }

  public void createDish(String name, String description, double price) {
    dishService.createDish(name, description, price);
    notifyObservers();
  }

  public List<DishModel> getAllDishes() {
    return dishService.getAllDishes();
  }

  public void updateDish(String name, String newDescription, double newPrice) {
    dishService.updateDish(name, newDescription, newPrice);
    notifyObservers();
  }

  public void deleteDish(String name) {
    dishService.deleteDish(name);
    notifyObservers();
  }

  public void addReviewToDish(String dishName, String reviewerName, int rating, String comment) {
    dishService.addReviewToDish(dishName, reviewerName, rating, comment);
    notifyObservers();
  }

  public List<DishReviewModel> getReviewsOfDish(String dishName) {
    return dishService.getReviewsOfDish(dishName);
  }

  public double getAverageRatingOfDish(String dishName) {
    return dishService.getAverageRatingOfDish(dishName);
  }



  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update("Dish updated");
    }
  }
}
