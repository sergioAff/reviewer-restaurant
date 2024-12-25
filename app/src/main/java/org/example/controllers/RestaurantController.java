package org.example.controllers;

import org.example.models.Restaurant;
import org.example.services.RestaurantService;

import java.util.Map;
import java.util.Optional;

public class RestaurantController {
  private final RestaurantService service;
  private static RestaurantController instance;

  public RestaurantController() {
    this.service = RestaurantService.getInstance();
  }

  public static RestaurantController getInstance() {
    if (instance == null) {
      instance = new RestaurantController();
    }
    return instance;
  }

  public boolean addRestaurant(Restaurant restaurant) {
    return service.addRestaurant(restaurant);
  }

  public Optional<Restaurant> getRestaurant(String name) {
    return service.getRestaurant(name);
  }

  public Map<String, Restaurant> getAllRestaurants() {
    return service.getAllRestaurants();
  }

  public boolean updateRestaurant(Restaurant restaurant) {
    return service.updateRestaurant(restaurant);
  }

  public boolean deleteRestaurant(String name) {
    return service.deleteRestaurant(name);
  }
}