package org.example.models;

import java.util.LinkedList;
import java.util.List;

public class DishModel {
  private String name;
  private String description;
  private Double price;
  private LinkedList<DishReviewModel> reviews;
  private Double averageRating;

  public DishModel(String name, String description, Double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative.");
    }
    this.name = name;
    this.description = description;
    this.price = price;
    this.reviews = new LinkedList<>();
    this.averageRating = 0.0;
  }

  private void calculateAverageRating() {
    if (reviews.isEmpty()) {
      this.averageRating = 0.0;
    } else {
      Double sum = 0.0;
      for (DishReviewModel review : reviews) {
        sum += review.getRating();
      }
      this.averageRating = sum / reviews.size();
    }
  }

  public void addReview(DishReviewModel review) {
    this.reviews.add(review);
    calculateAverageRating();
  }

  public void removeReview(DishReviewModel review) {
    this.reviews.remove(review);
    calculateAverageRating();
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
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative.");
    }
    this.price = price;
  }

  public List<DishReviewModel> getReviews() {
    return reviews;
  }

  public double getAverageRating() {
    return averageRating;
  }
}
