package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.DishReviewController;
import org.example.models.DishReviewModel;

import java.util.List;

public class ViewDishReviewsCommand implements ICommand {
  private final DishReviewController dishReviewController;
  private final IConsoleHandler consoleHandler;

  public ViewDishReviewsCommand(DishReviewController dishReviewController, IConsoleHandler consoleHandler) {
    this.dishReviewController = dishReviewController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter dish name:");
    String dishName = consoleHandler.readLine();
    List<DishReviewModel> reviews = dishReviewController.getReviewsOfDish(dishName);
    if (reviews == null || reviews.isEmpty()) {
      consoleHandler.writeLine("No reviews found for this dish.");
    } else {
      for (DishReviewModel review : reviews) {
        consoleHandler.writeLine("Reviewer: " + review.getReviewerName() + ", Rating: " + review.getRating() + ", Comment: " + review.getComment());
      }
    }
  }
}