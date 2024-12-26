package org.example.repositories;

import org.example.models.Restaurant;
import org.example.models.Review;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ReviewRepository {
  private static ReviewRepository instance;
  private Map<Restaurant, LinkedList<Review>> reviews;

  private ReviewRepository() {
  this.reviews=new HashMap<>();
  }

  public static synchronized ReviewRepository getInstance() {
    if (instance == null) {
      instance = new ReviewRepository();
    }
    return instance;
  }

  public void addReview(Restaurant restaurant, Review review) {
    if (reviews.get(restaurant) != null) {
      LinkedList<Review> reviewList = reviews.get(restaurant);
      reviewList.add(review);
      reviews.put(restaurant, reviewList);
    } else {
      LinkedList<Review> reviewList = new LinkedList<>();
      reviewList.add(review);
      reviews.put(restaurant, reviewList);
    }
  }

  public LinkedList<Review> getReviews(Restaurant restaurant) {
    return reviews.get(restaurant);
  }

}
