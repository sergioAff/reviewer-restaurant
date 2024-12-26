package org.example.services;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.repositories.MenuRepository;

import java.util.LinkedList;
import java.util.Optional;

public class MenuService {
  private static MenuService instance;
  private final MenuRepository menuRepository;

  private MenuService() {
    this.menuRepository = MenuRepository.getInstance();
  }

  public static synchronized MenuService getInstance() {
    if (instance == null) {
      instance = new MenuService();
    }
    return instance;
  }

  public boolean associateMenuToRestaurant(Restaurant restaurant, Menu menu) {
    menu.setRestaurant(restaurant);
    return menuRepository.saveMenu(menu);
  }

  public boolean addDishToMenu(Restaurant restaurant, Dish dish) {
    Optional<Menu> menuOptional = menuRepository.getMenu(restaurant.getName());
    if (menuOptional.isPresent()) {
      Menu menu = menuOptional.get();
      if (menu.getDishes() == null) {
        menu.setDishes(new LinkedList<>());
      }
      menu.getDishes().add(dish);
      return menuRepository.saveMenu(menu);
    }
    return false;
  }

  public boolean editDishInMenu(Restaurant restaurant, Dish updatedDish) {
    return menuRepository.updateDishInMenu(restaurant.getName(), updatedDish);
  }

  public boolean deleteDishFromMenu(Restaurant restaurant, String dishName) {
    return menuRepository.deleteDishFromMenu(restaurant.getName(), dishName);
  }
}