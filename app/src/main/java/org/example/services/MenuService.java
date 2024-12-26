package org.example.services;

import org.example.models.DishModel;
import org.example.models.MenuModel;
import org.example.models.RestaurantModel;
import org.example.repositories.DataRepository;

public class MenuService {
  private DataRepository repository;

  public MenuService() {
    this.repository = DataRepository.getInstance();
  }

  public void createMenuForRestaurant(String restaurantName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null) {
      MenuModel menu = new MenuModel(restaurant);
      restaurant.setMenu(menu);
    }
  }

  public void addDishToMenu(String restaurantName, DishModel dish) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null && restaurant.getMenu() != null) {
      restaurant.getMenu().addDish(dish);
      repository.addDish(dish); // Add the dish to the repository
    }
  }

  public void removeDishFromMenu(String restaurantName, String dishName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null && restaurant.getMenu() != null) {
      DishModel dish = repository.getDish(dishName);
      if (dish != null) {
        restaurant.getMenu().removeDish(dish);
        repository.removeDish(dishName); // Remove the dish from the repository
      }
    }
  }

  public MenuModel getMenuOfRestaurant(String restaurantName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null) {
      return restaurant.getMenu();
    }
    return null;
  }
}