package org.example.repositories;

import org.example.models.DishModel;
import org.example.models.MenuModel;
import org.example.models.RestaurantModel;
import org.example.models.Review;
import org.example.observable.Observer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataRepository {
  private static DataRepository instance;

  private Map<String, RestaurantModel> restaurants;
  private Map<String, DishModel> dishes;
  private List<Review> reviews;
  private List<Observer> observers;

  private DataRepository() {
    this.restaurants = new HashMap<>();
    this.dishes = new HashMap<>();
    this.reviews = new LinkedList<>();
    this.observers = new LinkedList<>();
  }

  public static synchronized DataRepository getInstance() {
    if (instance == null) {
      instance = new DataRepository();
    }
    return instance;
  }

  public void addRestaurant(RestaurantModel restaurant) {
    restaurants.put(restaurant.getName(), restaurant);
  }

  public RestaurantModel getRestaurant(String name) {
    return restaurants.get(name);
  }

  public List<RestaurantModel> getAllRestaurants() {
    return new LinkedList<>(restaurants.values());
  }

  public void removeRestaurant(String name) {
    restaurants.remove(name);
  }

  public void addDish(DishModel dish) {
    dishes.put(dish.getName(), dish);
  }

  public DishModel getDish(String name) {
    return dishes.get(name);
  }

  public List<DishModel> getAllDishes() {
    return new LinkedList<>(dishes.values());
  }

  public void removeDish(String name) {
    dishes.remove(name);
  }

  public void addReview(Review review) {
    reviews.add(review);
    notifyObservers();
  }

  public List<Review> getAllReviews() {
    return new LinkedList<>(reviews);
  }

  public void removeReview(Review review) {
    reviews.remove(review);
    notifyObservers();
  }

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update();
    }
  }
}