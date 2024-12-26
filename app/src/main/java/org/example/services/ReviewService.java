package org.example.services;

import org.example.models.DishModel;
import org.example.models.RestaurantModel;
import org.example.repositories.DataRepository;
import org.example.utils.ReviewFactory;

public class ReviewService {
  private DataRepository repository;
  private ReviewFactory reviewFactory;

  public ReviewService() {
    this.repository = DataRepository.getInstance();
    this.reviewFactory = new ReviewFactory();
  }

  public void addReviewToRestaurant(String restaurantName, String reviewerName, int rating, String comment) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null) {
      reviewFactory.createReview("Restaurant", reviewerName, rating, comment, restaurant);
    }
  }

  public void addReviewToDish(String dishName, String reviewerName, int rating, String comment) {
    DishModel dish = repository.getDish(dishName);
    if (dish != null) {
      reviewFactory.createReview("Dish", reviewerName, rating, comment, dish);
    }
  }
}