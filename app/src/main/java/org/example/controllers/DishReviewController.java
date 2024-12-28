package org.example.controllers;

import org.example.models.DishReviewModel;
import org.example.services.ReviewService;

import java.util.List;

public class DishReviewController {
  private final ReviewService reviewService;

  public DishReviewController() {
    this.reviewService = new ReviewService();
  }

  public void addReviewToDish(String dishName, String reviewerName, Double rating, String comment) {
    reviewService.addReviewToDish(dishName, reviewerName, rating, comment);
  }

  public List<DishReviewModel> getReviewsOfDish(String dishName) {
    return reviewService.getReviewsForDish(dishName);
  }

  public Double getAverageRatingOfDish(String dishName) {
    List<DishReviewModel> reviews = getReviewsOfDish(dishName);
    if (reviews == null || reviews.isEmpty()) {
      return 0.0;
    }
    return reviews.stream()
      .mapToDouble(DishReviewModel::getRating)
      .average()
      .orElse(0.0);
  }
}