package org.example.services;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.repositories.MenuRepository;

import java.util.Map;
import java.util.Optional;

public class MenuService {
  private final MenuRepository repository;

  public MenuService() {
    this.repository = MenuRepository.getInstance();
  }

  public boolean saveMenu(Menu menu) {
    return repository.saveMenu(menu);
  }

  public Optional<Menu> getMenu(Restaurant restaurant) {
    return repository.getMenu(restaurant);
  }

  public boolean updateDishInMenu(Restaurant restaurant, Dish updatedDish) {
    return repository.updateDishInMenu(restaurant, updatedDish);
  }

  public boolean deleteDishFromMenu(Restaurant restaurant, String dishName) {
    return repository.deleteDishFromMenu(restaurant, dishName);
  }

  public Map<Restaurant, Menu> getAllMenus() {
    return repository.getAllMenus();
  }
}