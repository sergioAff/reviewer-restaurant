package org.example.controllers;

import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;
import org.example.services.RestaurantService;
import org.example.services.ReviewService;

import java.util.List;

public class RestaurantController {
  private final RestaurantService restaurantService;
  private final ReviewService reviewService;


  public RestaurantController() {
    this.restaurantService = new RestaurantService();
    this.reviewService = new ReviewService();
  }

  public void createRestaurant(String name, String address, Boolean isAvailable) {
    restaurantService.createRestaurant(name, address, isAvailable);
  }

  public List<RestaurantModel> getAllRestaurants() {
    return restaurantService.getAllRestaurants();
  }

  public void updateRestaurant(String name, String newAddress, Boolean newAvailability) {
    restaurantService.updateRestaurant(name, newAddress, newAvailability);
  }

  public void deleteRestaurant(String name) {
    restaurantService.deleteRestaurant(name);
  }

  public void addReviewToRestaurant(String restaurantName, String reviewerName, Integer rating, String comment) {
    reviewService.addReviewToRestaurant(restaurantName, reviewerName, rating, comment);
  }

  public List<RestaurantReviewModel> getReviewsOfRestaurant(String restaurantName) {
    return reviewService.getReviewsForRestaurant(restaurantName);
  }

  public double getAverageRatingOfRestaurant(String restaurantName) {
    RestaurantModel restaurant = restaurantService.getAllRestaurants().stream()
      .filter(r -> r.getName().equals(restaurantName))
      .findFirst()
      .orElse(null);

    if (restaurant != null) {
      return restaurant.getAverageRating();
    }
    return 0.0;
  }
}