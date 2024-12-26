package org.example.models;

import java.util.LinkedList;
import java.util.List;

public class DishModel {
  private String name;
  private String description;
  private double price;
  private LinkedList<DishReviewModel> ReviewModels;
  private double averageRating;

  public DishModel(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.ReviewModels = new LinkedList<>();
    this.averageRating = 0.0;
  }

  private void calculateAverageRating() {
    if (ReviewModels.isEmpty()) {
      this.averageRating = 0.0;
    } else {
      double sum = 0.0;
      for (DishReviewModel ReviewModel : ReviewModels) {
        sum += ReviewModel.getRating();
      }
      this.averageRating = sum / ReviewModels.size();
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public List<DishReviewModel> getReview() {
    return ReviewModels;
  }

  public void setReview(LinkedList<DishReviewModel> ReviewModels) {
    this.ReviewModels = ReviewModels;
    calculateAverageRating();
  }

  public double getAverageRating() {
    return averageRating;
  }

  public void addReview(DishReviewModel ReviewModel) {
    this.ReviewModels.add(ReviewModel);
    calculateAverageRating();
  }

  public void removeReview(ReviewModel ReviewModel) {
    this.ReviewModels.remove(ReviewModel);
    calculateAverageRating();
  }

}