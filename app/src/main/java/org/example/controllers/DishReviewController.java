package org.example.controllers;

import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.repositories.DataRepository;
import org.example.utils.ReviewFactory;

import java.util.List;

public class DishReviewController {
  private DataRepository repository;
  private ReviewFactory reviewFactory;

  public DishReviewController() {
    this.repository = DataRepository.getInstance();
    this.reviewFactory = new ReviewFactory();
  }

  public void addReviewToDish(String dishName, String reviewerName, int rating, String comment) {
    DishModel dish = repository.getDish(dishName);
    if (dish != null) {
      reviewFactory.createReview("Dish", reviewerName, rating, comment, dish);
    }
  }

  public List<DishReviewModel> getReviewsOfDish(String dishName) {
    DishModel dish = repository.getDish(dishName);
    if (dish != null) {
      return dish.getReviews();
    }
    return null;
  }

  public double getAverageRatingOfDish(String dishName) {
    DishModel dish = repository.getDish(dishName);
    if (dish != null) {
      return dish.getAverageRating();
    }
    return 0.0;
  }
}