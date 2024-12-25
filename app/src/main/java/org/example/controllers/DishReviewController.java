package org.example.controllers;

import org.example.models.Menu;
import org.example.models.ReviewDish;
import org.example.services.DishReviewService;

public class DishReviewController {
  private final DishReviewService service;
  private static DishReviewController instance;

  public DishReviewController() {
    this.service = DishReviewService.getInstance();
  }

  public static DishReviewController getInstance() {
    if (instance == null) {
      instance = new DishReviewController();
    }
    return instance;
  }

  public boolean addReview(Menu menu, ReviewDish review) {
    return service.addReview(menu, review);
  }

  public ReviewDish getReview(Menu menu) {
    return service.getReview(menu);
  }

  public boolean deleteReview(Menu menu) {
    return service.deleteReview(menu);
  }

  public ReviewDish[] getAllReviews() {
    return service.getAllReviews();
  }
}