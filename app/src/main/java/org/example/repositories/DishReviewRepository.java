package org.example.repositories;

import org.example.models.Menu;
import org.example.models.ReviewDish;

import java.util.HashMap;
import java.util.Map;

public class DishReviewRepository {
  private static DishReviewRepository instance;
  private Map<Menu, ReviewDish> reviews;

  private DishReviewRepository() {
  this.reviews=new HashMap<>();
  }

  public static synchronized DishReviewRepository getInstance() {
    if (instance == null) {
      instance = new DishReviewRepository();
    }
    return instance;
  }

  public Boolean addReview(Menu menu, ReviewDish review) {
    if (reviews.get(menu) != null) {
      reviews.put(menu, review);
      return true;
    }
    return false;
  }

  public ReviewDish getReview(Menu menu) {
    return reviews.get(menu);
  }

  public Boolean deleteReview(Menu menu) {
    if (reviews.get(menu) != null) {
      reviews.remove(menu);
      return true;
    }
    return false;
  }

  public ReviewDish[] getAllReviews() {
    return reviews.values().toArray(new ReviewDish[0]);
  }
}
