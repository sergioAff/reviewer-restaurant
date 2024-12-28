package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.controllers.DishReviewController;
import org.example.models.DishModel;
import org.example.models.DishReviewModel;

public class CreateDishReviewCommand implements ICommand {
  private DishModel dish;
  private String reviewerName;
  private Integer rating;
  private String comment;
  private final DishReviewController dishReviewController = new DishReviewController();

  public CreateDishReviewCommand(DishModel dish, String reviewerName, int rating, String comment) {
    this.dish = dish;
    this.reviewerName = reviewerName;
    this.rating = rating;
    this.comment = comment;
  }

  @Override
  public void execute() {
    DishReviewModel review = new DishReviewModel(reviewerName, rating, comment, dish);
    dish.addReview(review);
    dishReviewController.addReviewToDish(dish.getName(), review.getReviewerName(), review.getRating(), review.getComment());
  }
}