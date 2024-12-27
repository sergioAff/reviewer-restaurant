package org.example.controllers;

import org.example.models.DishModel;
import org.example.models.MenuModel;
import org.example.services.MenuService;

import java.util.List;

public class MenuController {
  private final MenuService menuService;

  public MenuController() {
    this.menuService = new MenuService();
  }

  public void associateMenuToRestaurant(String restaurantName) {
    menuService.createMenuForRestaurant(restaurantName);
  }

  public void addDishToMenu(String restaurantName, DishModel dish) {
    menuService.addDishToMenu(restaurantName, dish);
  }

  public void removeDishFromMenu(String restaurantName, String dishName) {
    menuService.removeDishFromMenu(restaurantName, dishName);
  }

  public MenuModel getMenuOfRestaurant(String restaurantName) {
    return menuService.getMenuOfRestaurant(restaurantName);
  }

  public List<DishModel> getDishesInMenu(String restaurantName) {
    return menuService.getDishesInMenu(restaurantName);
  }
}
