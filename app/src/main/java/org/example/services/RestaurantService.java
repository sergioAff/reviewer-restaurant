package org.example.services;

import org.example.models.Restaurant;
import org.example.repositories.RestaurantRepository;

import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantService {
  private RestaurantRepository repository;
  private static RestaurantService instance;

  public static RestaurantService getInstance() {
    if (instance == null) {
      instance = new RestaurantService();
    }
    return instance;
  }

  public RestaurantService() {
    this.repository = RestaurantRepository.getInstance();
  }

  public Boolean addRestaurant(Restaurant restaurant) {
    return repository.addRestaurant(restaurant);
  }

  public Boolean updateRestaurant(Restaurant restaurant) {
    return repository.updateRestaurant(restaurant);
  }

  public Boolean deleteRestaurant(String name) {
    return repository.deleteRestaurant(name);
  }

  public Map<String, Restaurant> getAllRestaurants() {
    return repository.getAllRestaurants().entrySet().stream()
      .filter(entry -> entry.getValue().getCapacity() > 0)
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}