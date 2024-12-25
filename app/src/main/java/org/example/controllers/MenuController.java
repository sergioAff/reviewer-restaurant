package org.example.controllers;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.services.MenuService;

import java.util.Map;
import java.util.Optional;

public class MenuController {
  private MenuService service;
  private static MenuController instance;

  public MenuController() {
    this.service = MenuService.getInstance();
  }

  public static MenuController getInstance() {
    if (instance == null) {
      instance = new MenuController();
    }
    return instance;
  }

  public boolean saveMenu(Menu menu) {
    return service.saveMenu(menu);
  }

  public Optional<Menu> getMenu(Restaurant restaurant) {
    return service.getMenu(restaurant);
  }

  public boolean updateDishInMenu(Restaurant restaurant, Dish updatedDish) {
    return service.updateDishInMenu(restaurant, updatedDish);
  }

  public boolean deleteDishFromMenu(Restaurant restaurant, String dishName) {
    return service.deleteDishFromMenu(restaurant, dishName);
  }

  public Map<Restaurant, Menu> getAllMenus() {
    return service.getAllMenus();
  }
}