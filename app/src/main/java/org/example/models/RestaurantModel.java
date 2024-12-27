package org.example.models;

import java.util.LinkedList;
import java.util.List;

public class RestaurantModel {
  private String name;
  private String address;
  private MenuModel menu;
  private LinkedList<RestaurantReviewModel> reviews;
  private double averageRating;
  private boolean isAvailable;

  public RestaurantModel(String name, String address, boolean isAvailable) {
    this.name = name;
    this.address = address;
    this.reviews = new LinkedList<>();
    this.averageRating = 0.0;
    this.isAvailable = isAvailable;
  }

  private void calculateAverageRating() {
    if (reviews.isEmpty()) {
      this.averageRating = 0.0;
    } else {
      double sum = 0.0;
      for (RestaurantReviewModel review : reviews) {
        sum += review.getRating();
      }
      this.averageRating = sum / reviews.size();
    }
  }

  public void addReview(RestaurantReviewModel review) {
    this.reviews.add(review);
    calculateAverageRating();
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public MenuModel getMenu() {
    return menu;
  }

  public void setMenu(MenuModel menu) {
    this.menu = menu;
  }

  public List<RestaurantReviewModel> getReviews() {
    return reviews;
  }

  public double getAverageRating() {
    return averageRating;
  }

}
