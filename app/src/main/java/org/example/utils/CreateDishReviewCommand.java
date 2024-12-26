package org.example.utils;

import org.example.Interface.ICommand;
import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.models.ReviewModel;

public class CreateDishReviewCommand implements ICommand {
  private DishModel dish;
  private String reviewerName;
  private int rating;
  private String comment;

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
  }
}
