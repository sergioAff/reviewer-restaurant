package org.example.services;

import org.example.models.DishModel;
import org.example.models.MenuModel;
import org.example.models.RestaurantModel;
import org.example.repositories.DataRepository;

import java.util.List;

public class MenuService {
  private final DataRepository repository;

  public MenuService() {
    this.repository = DataRepository.getInstance();
  }

  public void createMenuForRestaurant(String restaurantName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurantName);
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
      repository.addDish(dish); // Agregar el plato al repositorio si aún no existe.
    }
  }

  public void removeDishFromMenu(String restaurantName, String dishName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    if (restaurant == null || restaurant.getMenu() == null) {
      throw new IllegalArgumentException("Restaurant or menu not found.");
    }
    DishModel dish = repository.getDish(dishName);
    if (dish == null) {
      throw new IllegalArgumentException("Dish not found: " + dishName);
    }
    restaurant.getMenu().removeDish(dish);
    repository.removeDish(dishName); // Eliminar el plato del repositorio.
  }

  public MenuModel getMenuOfRestaurant(String restaurantName) {
    RestaurantModel restaurant = repository.getRestaurant(restaurantName);
    return restaurant != null ? restaurant.getMenu() : null;
  }

  public List<DishModel> getDishesInMenu(String restaurantName) {
    MenuModel menu = getMenuOfRestaurant(restaurantName);
    if (menu == null) {
      throw new IllegalArgumentException("Menu not found for restaurant: " + restaurantName);
    }
    return menu.getDishes();
  }
}
