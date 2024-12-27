package org.example.repositories;

import org.example.models.DishModel;
import org.example.models.RestaurantModel;
import org.example.models.Review;

import java.util.*;

public class DataRepository {

  private static DataRepository instance;

  private final Map<String, RestaurantModel> restaurants;
  private final Map<String, DishModel> dishes;
  private final List<Review> reviews;

  private DataRepository() {
    this.restaurants = new HashMap<>();
    this.dishes = new HashMap<>();
    this.reviews = new LinkedList<>();
  }

  public static DataRepository getInstance() {
    if (instance == null) {
      synchronized (DataRepository.class) {
        if (instance == null) {
          instance = new DataRepository();
        }
      }
    }
    return instance;
  }

  public void addRestaurant(RestaurantModel restaurant) {
    Objects.requireNonNull(restaurant, "Restaurant cannot be null.");
    if (restaurants.containsKey(restaurant.getName())) {
      throw new IllegalArgumentException("Restaurant already exists: " + restaurant.getName());
    }
    restaurants.put(restaurant.getName(), restaurant);
  }

  public void updateRestaurant(RestaurantModel restaurant) {
    Objects.requireNonNull(restaurant, "Restaurant cannot be null.");
    if (!restaurants.containsKey(restaurant.getName())) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurant.getName());
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
    Objects.requireNonNull(dish, "Dish cannot be null.");
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

  public void updateDish(DishModel dish) {
    Objects.requireNonNull(dish, "Dish cannot be null.");
    if (!dishes.containsKey(dish.getName())) {
      throw new IllegalArgumentException("Dish not found: " + dish.getName());
    }
    dishes.put(dish.getName(), dish);
  }

  public void addReview(Review review) {
    Objects.requireNonNull(review, "Review cannot be null.");
    reviews.add(review);
  }

  public List<Review> getAllReviews() {
    return new ArrayList<>(reviews);
  }

  public void removeReview(Review review) {
    if (!reviews.remove(review)) {
      throw new IllegalArgumentException("Review not found.");
    }
  }
}
