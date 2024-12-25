package org.example.controllers;

import org.example.models.Restaurant;
import org.example.models.Review;
import org.example.services.RestaurantReviewService;

public class RestaurantReviewController {
  private final RestaurantReviewService service;
  private static RestaurantReviewController instance;

  public RestaurantReviewController() {
    this.service = RestaurantReviewService.getInstance();
  }

  public static RestaurantReviewController getInstance() {
    if (instance == null) {
      instance = new RestaurantReviewController();
    }
    return instance;
  }

  public boolean addReview(Restaurant restaurant, Review review) {
    return service.addReview(restaurant, review);
  }

  public Review[] getReviews(Restaurant restaurant) {
    return service.getReviews(restaurant);
  }

  public boolean deleteReview(Restaurant restaurant, Review review) {
    return service.deleteReview(restaurant, review);
  }
}