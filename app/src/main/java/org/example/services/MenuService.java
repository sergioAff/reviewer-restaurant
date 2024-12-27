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
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant not found.");
    }
    if (restaurant.getMenu() != null) {
      throw new IllegalArgumentException("Restaurant already has a menu.");
    }
    MenuModel menu = new MenuModel(restaurant);
    restaurant.setMenu(menu);
  }

  public void addDishToMenu(String restaurantName, DishModel dish) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant == null || restaurant.getMenu() == null) {
      throw new IllegalArgumentException("Restaurant or menu not found.");
    }
    restaurant.getMenu().addDish(dish);
    if (repository.getDish(dish.getName()) == null) {
      repository.addDish(dish);
    }
  }

  public void removeDishFromMenu(String restaurantName, String dishName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant == null || restaurant.getMenu() == null) {
      throw new IllegalArgumentException("Restaurant or menu not found.");
    }
    DishModel dish = repository.getDish(dishName);
    if (dish == null) {
      throw new IllegalArgumentException("Dish not found.");
    }
    restaurant.getMenu().removeDish(dish);
    repository.removeDish(dishName);
  }

  public MenuModel getMenuOfRestaurant(String restaurantName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    return restaurant != null ? restaurant.getMenu() : null;
  }
}
