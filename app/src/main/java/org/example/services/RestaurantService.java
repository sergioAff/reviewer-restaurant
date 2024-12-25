package org.example.services;

import org.example.models.Restaurant;
import org.example.repositories.RestauranteRepository;

import java.util.Map;
import java.util.Optional;

public class RestaurantService {
  private RestauranteRepository repository;
  private static RestaurantService instance;

  public static RestaurantService getInstance() {
    if (instance == null) {
      instance = new RestaurantService();
    }
    return instance;
  }

  public RestaurantService() {
    this.repository = RestauranteRepository.getInstance();
  }

  public boolean addRestaurant(Restaurant restaurant) {
    return repository.addRestaurant(restaurant);
  }

  public Optional<Restaurant> getRestaurant(String name) {
    return repository.getRestaurant(name);
  }

  public Map<String, Restaurant> getAllRestaurants() {
    return repository.getAllRestaurants();
  }

  public boolean updateRestaurant(Restaurant restaurant) {
    return repository.updateRestaurant(restaurant);
  }

  public boolean deleteRestaurant(String name) {
    return repository.deleteRestaurant(name);
  }
}