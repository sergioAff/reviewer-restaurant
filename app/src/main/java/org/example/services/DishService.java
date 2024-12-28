package org.example.services;

import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.Interface.observable.Observer;
import org.example.repositories.DataRepository;
import org.example.utils.ReviewFactory;

import java.util.List;

public class DishService implements Observer {
  private final DataRepository repository;
  private final ReviewFactory reviewFactory;

  public DishService() {
    this.repository = DataRepository.getInstance();
    this.reviewFactory = new ReviewFactory();
    repository.addObserver(this);
  }

  public void createDish(String name, String description, double price) {
    DishModel dish = new DishModel(name, description, price);
    repository.addDish(dish);
  }

  public List<DishModel> getAllDishes(String name) {
    return repository.getAllDishes(name);
  }

  public void updateDish(String name, String newDescription, Double newPrice) {
    DishModel dish = repository.getDish(name);
    if (dish != null) {
      dish.setDescription(newDescription);
      dish.setPrice(newPrice);
    } else {
      throw new IllegalArgumentException("Dish not found: " + name);
    }
  }

  public void addReviewToDish(String dishName, String reviewerName, Double rating, String comment) {
    DishModel dish = repository.getDish(dishName);
    if (dish != null) {
      reviewFactory.createReview("Dish", reviewerName, rating, comment, dish);
    } else {
      throw new IllegalArgumentException("Dish not found: " + dishName);
    }
  }

  public List<DishReviewModel> getReviewsOfDish(String dishName) {
    DishModel dish = repository.getDish(dishName);
    if (dish != null) {
      return dish.getReviews();
    } else {
      throw new IllegalArgumentException("Dish not found: " + dishName);
    }
  }

  public double getAverageRatingOfDish(String dishName) {
    DishModel dish = repository.getDish(dishName);
    if (dish != null) {
      return dish.getAverageRating();
    } else {
      throw new IllegalArgumentException("Dish not found: " + dishName);
    }
  }

  @Override
  public void update(String message) {
    if (message.toLowerCase().contains("dish")) {
      System.out.println("DishService received notification: " + message);
    }
  }
}
