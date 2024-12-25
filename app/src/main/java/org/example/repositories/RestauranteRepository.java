package org.example.repositories;

import org.example.models.Restaurant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RestauranteRepository {
  private static RestauranteRepository instance;
  private Map<String, Restaurant> restaurants;

  private RestauranteRepository() {
    this.restaurants = new HashMap<>();
  }

  public static synchronized RestauranteRepository getInstance() {
    if (instance == null) {
      instance = new RestauranteRepository();
    }
    return instance;
  }

  public Boolean addRestaurant(Restaurant restaurant) {
    String restaurantName=restaurant.getName();
    if ( restaurants.get(restaurantName) !=null ) {
      restaurants.put(restaurantName, restaurant);
      return true;
    }
    return false;
  }

  public Optional<Restaurant> getRestaurant(String name) {
    return Optional.ofNullable(restaurants.get(name));
  }

  public Map<String, Restaurant> getAllRestaurants() {
    return new HashMap<>(restaurants);
  }

  public Boolean updateRestaurant(Restaurant restaurant) {
    if (restaurants.get(restaurant.getName()) != null) {
      restaurants.put(restaurant.getName(), restaurant);
      return true;
    }
    return false;
  }

  public Boolean deleteRestaurant(String name) {
    if (restaurants.get(name) != null){
    restaurants.remove(name);
    return true;
    }
    return false;
  }
}