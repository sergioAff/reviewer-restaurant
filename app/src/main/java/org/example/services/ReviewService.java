package org.example.services;

import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;
import org.example.Interface.observable.Observer;
import org.example.repositories.DataRepository;

import java.util.List;

public class ReviewService implements Observer {
  private final DataRepository repository;

  public ReviewService() {
    this.repository = DataRepository.getInstance();
    repository.addObserver(this);
  }

  public void addReviewToRestaurant(String restaurantName, String reviewerName, Double rating, String comment) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurantName);
    }
    repository.addReviewToRestaurant(new RestaurantReviewModel(reviewerName, rating, comment, restaurant));
  }

  public void addReviewToDish(String dishName, String reviewerName, Double rating, String comment) {
    DishModel dish = repository.getDish(dishName);
    if (dish == null) {
      throw new IllegalArgumentException("Dish not found: " + dishName);
    }
    repository.addReviewToDish(new DishReviewModel(reviewerName, rating, comment, dish));
  }

  public List<RestaurantReviewModel> getReviewsForRestaurant(String restaurantName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurantName);
    }
    return restaurant.getReviews();
  }

  public List<DishReviewModel> getReviewsForDish(String dishName) {
    DishModel dish = repository.getDish(dishName);
    if (dish == null) {
      throw new IllegalArgumentException("Dish not found: " + dishName);
    }
    return dish.getReviews();
  }


  @Override
  public void update(String message) {
    if (message.contains("Review")||message.contains("review")) {
      System.out.println("ReviewService received notification: " + message);
    }
  }
}
