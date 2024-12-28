package org.example.repositories;

import org.example.models.DishModel;
import org.example.models.RestaurantModel;
import org.example.models.Review;
import org.example.observable.Observable;
import org.example.observable.Observer;

import java.util.*;

public class DataRepository implements Observable {

  private static DataRepository instance;

  private final Map<String, RestaurantModel> restaurants;
  private final Map<String, DishModel> dishes;
  private final List<Review> reviews;
  private final List<Observer> observers;

  private DataRepository() {
    this.restaurants = new HashMap<>();
    this.dishes = new HashMap<>();
    this.reviews = new LinkedList<>();
    this.observers = new ArrayList<>();
  }

  public static DataRepository getInstance() {
    if (instance == null) {
      synchronized (DataRepository.class) {
        instance = new DataRepository();
      }
    }
    return instance;
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
  public void notifyObservers(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

  public void addRestaurant(RestaurantModel restaurant) {
    Objects.requireNonNull(restaurant, "Restaurant cannot be null.");
    if (restaurants.containsKey(restaurant.getName())) {
      throw new IllegalArgumentException("Restaurant already exists: " + restaurant.getName());
    }
    restaurants.put(restaurant.getName(), restaurant);
    notifyObservers("New restaurant added: " + restaurant.getName());
  }

  public void updateRestaurant(RestaurantModel restaurant) {
    Objects.requireNonNull(restaurant, "Restaurant cannot be null.");
    if (!restaurants.containsKey(restaurant.getName())) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurant.getName());
    }
    restaurants.put(restaurant.getName(), restaurant);
    notifyObservers("Restaurant updated: " + restaurant.getName());
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
    notifyObservers("Restaurant removed: " + name);
  }

  public void addDish(DishModel dish) {
    Objects.requireNonNull(dish, "Dish cannot be null.");
    if (dishes.containsKey(dish.getName())) {
      throw new IllegalArgumentException("Dish already exists: " + dish.getName());
    }
    dishes.put(dish.getName(), dish);
    notifyObservers("New dish added: " + dish.getName());
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
    notifyObservers("Dish removed: " + name);
  }

  public void updateDish(DishModel dish) {
    Objects.requireNonNull(dish, "Dish cannot be null.");
    if (!dishes.containsKey(dish.getName())) {
      throw new IllegalArgumentException("Dish not found: " + dish.getName());
    }
    dishes.put(dish.getName(), dish);
    notifyObservers("Dish updated: " + dish.getName());
  }

  public void addReview(Review review) {
    Objects.requireNonNull(review, "Review cannot be null.");
    reviews.add(review);
    notifyObservers("New review added");
  }

  public List<Review> getAllReviews() {
    return new ArrayList<>(reviews);
  }

  public void removeReview(Review review) {
    if (!reviews.remove(review)) {
      throw new IllegalArgumentException("Review not found.");
    }
    notifyObservers("Review removed");
  }
}