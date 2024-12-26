package org.example.models;

import java.util.LinkedList;
import java.util.List;

public class RestaurantModel {
  private String name;
  private String address;
  private MenuModel MenuModel;
  private LinkedList<RestaurantReviewModel> ReviewModels;
  private double averageRating;
  private boolean isAvailable;

  public RestaurantModel(String name, String address, Boolean isAvailable) {
    this.name = name;
    this.address = address;
    this.ReviewModels = new LinkedList<>();
    this.averageRating = 0.0;
    this.isAvailable= isAvailable;
  }

  private void calculateAverageRating() {
    if (ReviewModels.isEmpty()) {
      this.averageRating = 0.0;
    } else {
      double sum = 0.0;
      for (RestaurantReviewModel ReviewModel : ReviewModels) {
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public MenuModel getMenu() {
    return MenuModel;
  }

  public void setMenu(MenuModel MenuModel) {
    this.MenuModel = MenuModel;
  }

  public List<RestaurantReviewModel> getReview() {
    return ReviewModels;
  }

  public void setReview(LinkedList<RestaurantReviewModel> ReviewModels) {
    this.ReviewModels = ReviewModels;
    calculateAverageRating();
  }

  public double getAverageRating() {
    return averageRating;
  }

  public void addReview(RestaurantReviewModel ReviewModel) {
    this.ReviewModels.add(ReviewModel);
    calculateAverageRating();
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

}