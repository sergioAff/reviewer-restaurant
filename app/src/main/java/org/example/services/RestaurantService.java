package org.example.services;

import org.example.models.RestaurantModel;
import org.example.repositories.DataRepository;

import java.util.List;

public class RestaurantService {
  private final DataRepository repository;

  public RestaurantService() {
    this.repository = DataRepository.getInstance();
  }

  public void createRestaurant(String name, String address, boolean isAvailable) {
    if (repository.getRestaurant(name) != null) {
      throw new IllegalArgumentException("Restaurant with this name already exists.");
    }
    RestaurantModel restaurant = new RestaurantModel(name, address, isAvailable);
    repository.addRestaurant(restaurant);
  }

  public List<RestaurantModel> getAllRestaurants() {
    return repository.getAllRestaurants();
  }

  public void updateRestaurant(String name, String newAddress, boolean newAvailability) {
    RestaurantModel restaurant = repository.getRestaurant(name);
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant not found.");
    }
    restaurant.setAddress(newAddress);
    restaurant.setAvailable(newAvailability);
    repository.updateRestaurant(restaurant);
  }

  public void deleteRestaurant(String name) {
    if (repository.getRestaurant(name) == null) {
      throw new IllegalArgumentException("Restaurant not found.");
    }
    repository.removeRestaurant(name);
  }
}