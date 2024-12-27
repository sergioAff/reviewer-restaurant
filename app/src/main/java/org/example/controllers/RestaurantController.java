package org.example.controllers;

import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;
import org.example.observable.Observable;
import org.example.observable.Observer;
import org.example.services.RestaurantService;
import org.example.services.ReviewService;

import java.util.ArrayList;
import java.util.List;

public class RestaurantController implements Observable {
  private final RestaurantService restaurantService;
  private final ReviewService reviewService;
  private final List<Observer> observers;

  public RestaurantController() {
    this.restaurantService = new RestaurantService();
    this.reviewService = new ReviewService();
    this.observers = new ArrayList<>();
  }

  public void createRestaurant(String name, String address, boolean isAvailable) {
    restaurantService.createRestaurant(name, address, isAvailable);
    notifyObservers();
  }

  public List<RestaurantModel> getAllRestaurants() {
    return restaurantService.getAllRestaurants();
  }

  public void updateRestaurant(String name, String newAddress, boolean newAvailability) {
    restaurantService.updateRestaurant(name, newAddress, newAvailability);
    notifyObservers();
  }

  public void deleteRestaurant(String name) {
    restaurantService.deleteRestaurant(name);
    notifyObservers();
  }

  public void addReviewToRestaurant(String restaurantName, String reviewerName, int rating, String comment) {
    reviewService.addReviewToRestaurant(restaurantName, reviewerName, rating, comment);
    notifyObservers();
  }

  public List<RestaurantReviewModel> getReviewsOfRestaurant(String restaurantName) {
    return reviewService.getReviewsForRestaurant(restaurantName);
  }

  public double getAverageRatingOfRestaurant(String restaurantName) {
    RestaurantModel restaurant = restaurantService.getAllRestaurants().stream()
      .filter(r -> r.getName().equals(restaurantName))
      .findFirst()
      .orElse(null);

    if (restaurant != null) {
      return restaurant.getAverageRating();
    }
    return 0.0;
  }

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update("Restaurant updated");
    }
  }
}