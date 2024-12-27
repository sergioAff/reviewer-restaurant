package org.example.repositories;

import org.example.models.DishModel;
import org.example.models.RestaurantModel;
import org.example.models.Review;
import org.example.observable.Observer;

import java.util.*;

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
    if (restaurants.containsKey(restaurant.getName())) {
      throw new IllegalArgumentException("Restaurant already exists: " + restaurant.getName());
    }
    restaurants.put(restaurant.getName(), restaurant);
  }

  public RestaurantModel getRestaurant(String name) {
    return restaurants.get(name);
  }

  public List<RestaurantModel> getAllRestaurants() {
    return new ArrayList<>(restaurants.values());
  }

  public void removeRestaurant(String name) {
    if (!restaurants.containsKey(name)) {
      throw new IllegalArgumentException("Restaurant not found: " + name);
    }
    restaurants.remove(name);
  }

  public void addDish(DishModel dish) {
    if (dishes.containsKey(dish.getName())) {
      throw new IllegalArgumentException("Dish already exists: " + dish.getName());
    }
    dishes.put(dish.getName(), dish);
  }

  public DishModel getDish(String name) {
    return dishes.get(name);
  }

  public List<DishModel> getAllDishes() {
    return new ArrayList<>(dishes.values());
  }

  public void removeDish(String name) {
    if (!dishes.containsKey(name)) {
      throw new IllegalArgumentException("Dish not found: " + name);
    }
    dishes.remove(name);
  }

  public void addReview(Review review) {
    reviews.add(review);
    notifyObservers("New review added: " + review.getComment());
  }

  public List<Review> getAllReviews() {
    return new ArrayList<>(reviews);
  }

  public void removeReview(Review review) {
    if (!reviews.remove(review)) {
      throw new IllegalArgumentException("Review not found.");
    }
    notifyObservers("Review removed: " + review.getComment());
  }

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers(String mensaje) {
    for (Observer observer : observers) {
      observer.update(mensaje);
    }
  }
}
