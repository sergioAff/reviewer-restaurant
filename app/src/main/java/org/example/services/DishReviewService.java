package org.example.services;

import org.example.models.Menu;
import org.example.models.ReviewDish;
import org.example.repositories.DishReviewRepository;

public class DishReviewService {
  private final DishReviewRepository repository;

  public DishReviewService() {
    this.repository = DishReviewRepository.getInstance();
  }

  public boolean addReview(Menu menu, ReviewDish review) {
    return repository.addReview(menu, review);
  }

  public ReviewDish getReview(Menu menu) {
    return repository.getReview(menu);
  }

  public boolean deleteReview(Menu menu) {
    return repository.deleteReview(menu);
  }

  public ReviewDish[] getAllReviews() {
    return repository.getAllReviews();
  }
}