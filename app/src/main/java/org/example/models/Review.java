package org.example.models;

public class Review {
  private Restaurant restaurant;
  private Double rating;
  private String comment;

  public Review() {
  }

  public Review(Restaurant restaurant, Double rating, String comment) {
    this.restaurant = restaurant;
    this.rating = rating;
    this.comment = comment;
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
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
