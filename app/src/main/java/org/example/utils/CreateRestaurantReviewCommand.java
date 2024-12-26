package org.example.utils;

import org.example.Interface.ICommand;
import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;

public class CreateRestaurantReviewCommand implements ICommand {
  private RestaurantModel restaurant;
  private String reviewerName;
  private int rating;
  private String comment;

  public CreateRestaurantReviewCommand(RestaurantModel restaurant, String reviewerName, int rating, String comment) {
    this.restaurant = restaurant;
    this.reviewerName = reviewerName;
    this.rating = rating;
    this.comment = comment;
  }

  @Override
  public void execute() {
    RestaurantReviewModel review = new RestaurantReviewModel(reviewerName, rating, comment, restaurant);
    restaurant.addReview(review);
  }
}

