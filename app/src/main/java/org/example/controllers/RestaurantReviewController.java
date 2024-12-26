package org.example.controllers;

import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;
import org.example.repositories.DataRepository;
import org.example.utils.ReviewFactory;

import java.util.List;

public class RestaurantReviewController {
  private DataRepository repository;
  private ReviewFactory reviewFactory;

  public RestaurantReviewController() {
    this.repository = DataRepository.getInstance();
    this.reviewFactory = new ReviewFactory();
  }

  public void addReviewToRestaurant(String restaurantName, String reviewerName, int rating, String comment) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null) {
      reviewFactory.createReview("Restaurant", reviewerName, rating, comment, restaurant);
    }
  }

  public List<RestaurantReviewModel> getReviewsOfRestaurant(String restaurantName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null) {
      return restaurant.getReviews();
    }
    return null;
  }

  public double getAverageRatingOfRestaurant(String restaurantName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null) {
      return restaurant.getAverageRating();
    }
    return 0.0;
  }
}