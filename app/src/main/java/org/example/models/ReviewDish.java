package org.example.models;

public class ReviewDish {
  private Dish dish;
  private Double rating;
  private String comment;

  public ReviewDish() {
  }

  public ReviewDish(Dish dish, Double rating, String comment) {
    this.dish = dish;
    this.rating = rating;
    this.comment = comment;
  }

  public Dish getDish() {
    return dish;
  }

  public void setDish(Dish dish) {
    this.dish = dish;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
