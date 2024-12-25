package org.example.services;

import org.example.models.Menu;
import org.example.models.ReviewDish;
import org.example.repositories.DishReviewRepository;

public class DishReviewService {
  private DishReviewRepository repository;
  private DishReviewService instance;

  public static DishReviewService getInstance() {
    if (instance == null) {
      instance = new DishReviewService();
    }
    return instance;
  }

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