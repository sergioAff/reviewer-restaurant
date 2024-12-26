package org.example.controllers;

import org.example.models.DishModel;
import org.example.models.MenuModel;
import org.example.models.RestaurantModel;
import org.example.repositories.DataRepository;

public class MenuController {
  private DataRepository repository;

  public MenuController() {
    this.repository = DataRepository.getInstance();
  }

  public void associateMenuToRestaurant(String restaurantName, MenuModel menu) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null) {
      restaurant.setMenu(menu);
      menu.setRestaurant(restaurant);
    }
  }

  public void addDishToMenu(String restaurantName, DishModel dish) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null && restaurant.getMenu() != null) {
      restaurant.getMenu().addDish(dish);
    }
  }

  public void removeDishFromMenu(String restaurantName, String dishName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant != null && restaurant.getMenu() != null) {
      DishModel dish = repository.getDish(dishName);
      if (dish != null) {
        restaurant.getMenu().removeDish(dish);
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