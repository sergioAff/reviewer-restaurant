package org.example.services;

import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;
import org.example.repositories.DataRepository;
import org.example.utils.ReviewFactory;

import java.util.List;

public class ReviewService {
  private final DataRepository repository;
  private final ReviewFactory reviewFactory;

  public ReviewService() {
    this.repository = DataRepository.getInstance();
    this.reviewFactory = new ReviewFactory();
  }

  public void addReviewToRestaurant(String restaurantName, String reviewerName, int rating, String comment) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurantName);
    }
    reviewFactory.createReview("Restaurant", reviewerName, rating, comment, restaurant);
  }

  public void addReviewToDish(String dishName, String reviewerName, int rating, String comment) {
    DishModel dish = repository.getDish(dishName);
    if (dish == null) {
      throw new IllegalArgumentException("Dish not found: " + dishName);
    }
    reviewFactory.createReview("Dish", reviewerName, rating, comment, dish);
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
}
