package org.example.services;

import org.example.models.Restaurant;
import org.example.models.Review;
import org.example.repositories.RestaurantReviewRepository;

public class RestaurantReviewService {
  private RestaurantReviewRepository repository;
  private RestaurantReviewService instance;

  public static RestaurantReviewService getInstance() {
    if (instance == null) {
      instance = new RestaurantReviewService();
    }
    return instance;
  }

  public RestaurantReviewService() {
    this.repository = RestaurantReviewRepository.getInstance();
  }

  public boolean addReview(Restaurant restaurant, Review review) {
    return repository.addReview(restaurant, review);
  }

  public Review[] getReviews(Restaurant restaurant) {
    return repository.getReviews(restaurant);
  }

  public boolean deleteReview(Restaurant restaurant, Review review) {
    return repository.deleteReview(restaurant, review);
  }
}