package org.example.services;

import org.example.models.RestaurantModel;
import org.example.repositories.DataRepository;

import java.util.List;

public class RestaurantService {
  private DataRepository repository;

  public RestaurantService() {
    this.repository = DataRepository.getInstance();
  }

  public void createRestaurant(String name, String address, boolean isAvailable) {
    RestaurantModel restaurant = new RestaurantModel(name, address, isAvailable);
    repository.addRestaurant(restaurant);
  }

  public List<RestaurantModel> getAllRestaurants() {
    return repository.getAllRestaurants();
  }

  public void updateRestaurant(String name, String newAddress, boolean newAvailability) {
    RestaurantModel restaurant = repository.getRestaurant(name);
    if (restaurant != null) {
      restaurant.setAddress(newAddress);
      restaurant.setAvailable(newAvailability);
    }
  }

  public void deleteRestaurant(String name) {
    repository.removeRestaurant(name);
  }
}