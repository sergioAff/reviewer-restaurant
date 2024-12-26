package org.example.services;

import org.example.models.Restaurant;
import org.example.models.Review;
import org.example.repositories.ReviewRepository;

import java.util.LinkedList;
import java.util.OptionalDouble;

public class ReviewService {
  private static ReviewService instance;
  private final ReviewRepository reviewRepository;

  private ReviewService() {
    this.reviewRepository = ReviewRepository.getInstance();
  }

  public static synchronized ReviewService getInstance() {
    if (instance == null) {
      instance = new ReviewService();
    }
    return instance;
  }

  public void createReview(Restaurant restaurant, Double rating, String comment) {
    Review review = new Review(restaurant, rating, comment);
    reviewRepository.addReview(restaurant, review);
  }

  public LinkedList<Review> listReviews(Restaurant restaurant) {
    return reviewRepository.getReviews(restaurant);
  }

  public double calculateAverageRating(Restaurant restaurant) {
    LinkedList<Review> reviews = reviewRepository.getReviews(restaurant);
    if (reviews == null || reviews.isEmpty()) {
      return 0.0;
    }
    OptionalDouble average = reviews.stream().mapToDouble(Review::getRating).average();
    return average.orElse(0.0);
  }
}