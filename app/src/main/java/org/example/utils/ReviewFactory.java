package org.example.utils;

import org.example.Interface.ICommand;
import org.example.models.DishModel;
import org.example.models.RestaurantModel;

public class ReviewFactory {
  private ReviewInvoker invoker;

  public ReviewFactory() {
    this.invoker = new ReviewInvoker();
  }

  public void createReview(String reviewType, String reviewerName, int rating, String comment, Object target) {
    ICommand command;
    if ("Restaurant".equals(reviewType) && target instanceof RestaurantModel) {
      command = new CreateRestaurantReviewCommand((RestaurantModel) target, reviewerName, rating, comment);
    } else if ("Dish".equals(reviewType) && target instanceof DishModel) {
      command = new CreateDishReviewCommand((DishModel) target, reviewerName, rating, comment);
    } else {
      throw new IllegalArgumentException("Invalid review type or target");
    }
    invoker.setCommand(command);
    invoker.executeCommand();
  }
}