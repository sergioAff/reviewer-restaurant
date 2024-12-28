package org.example.commands.Restaurants;

import org.example.Interface.ICommand;
import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;
import org.example.controllers.RestaurantReviewController;

public class CreateRestaurantReviewCommand implements ICommand {
  private RestaurantModel restaurant;
  private String reviewerName;
  private Integer rating;
  private String comment;
  private final RestaurantReviewController RestaurantReviewController = new RestaurantReviewController();

  public CreateRestaurantReviewCommand(RestaurantModel restaurant, String reviewerName, Integer rating, String comment) {
    this.restaurant = restaurant;
    this.reviewerName = reviewerName;
    this.rating = rating;
    this.comment = comment;
  }

  @Override
  public void execute() {
    RestaurantReviewModel review = new RestaurantReviewModel(reviewerName, rating, comment, restaurant);
    restaurant.addReview(review);
    RestaurantReviewController.addReviewToRestaurant(restaurant.getName(), review.getReviewerName(), review.getRating(), review.getComment());
  }
}