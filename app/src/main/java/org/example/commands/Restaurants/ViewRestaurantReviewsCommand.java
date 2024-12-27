package org.example.commands.Restaurants;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.RestaurantReviewController;
import org.example.models.RestaurantReviewModel;

import java.util.List;

public class ViewRestaurantReviewsCommand implements ICommand {
  private final RestaurantReviewController restaurantReviewController;
  private final IConsoleHandler consoleHandler;

  public ViewRestaurantReviewsCommand(RestaurantReviewController restaurantReviewController, IConsoleHandler consoleHandler) {
    this.restaurantReviewController = restaurantReviewController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    List<RestaurantReviewModel> reviews = restaurantReviewController.getReviewsOfRestaurant(restaurantName);
    if (reviews == null || reviews.isEmpty()) {
      consoleHandler.writeLine("No reviews found for this restaurant.");
    } else {
      for (RestaurantReviewModel review : reviews) {
        consoleHandler.writeLine("Reviewer: " + review.getReviewerName() + ", Rating: " + review.getRating() + ", Comment: " + review.getComment());
      }
    }
  }
}