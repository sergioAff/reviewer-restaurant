package org.example.repositories;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

public class MenuRepository {

  private static MenuRepository instance;
  private final Map<String, Menu> menus;

  private MenuRepository() {
    menus = new HashMap<>();
  }

  public static MenuRepository getInstance() {
    if (instance == null) {
      instance = new MenuRepository();
    }
    return instance;
  }

  public boolean saveMenu(Menu menu) {
    if (menus.get(menu.getRestaurant().getName()) == null) {
      menus.put(menu.getRestaurant().getName(), menu);
      return true;
    }
    return false;
  }

  public Boolean updateDishInMenu(String restaurant, Dish updatedDish) {
   if ( menus.get(restaurant) != null ) {
     LinkedList<Dish> dishes = menus.get(restaurant).getDishes();
      for (Dish dish : dishes) {
        if (dish.getName().equals(updatedDish.getName())) {
          dish.setPrice(updatedDish.getPrice());
          dish.setDescription(updatedDish.getDescription());
          return true;
        }
      }
   }
   return false;
  }

  public Boolean deleteDishFromMenu(String restaurant, String dishName) {
    if (menus.get(restaurant) != null) {
      LinkedList<Dish> dishes = menus.get(restaurant).getDishes();
      for (Dish dish : dishes) {
        if (dish.getName().equals(dishName)) {
          dishes.remove(dish);
          return true;
        }
      }
    }
    return false;
  }

  public Optional<Menu> getMenu(String restaurant) {
    return Optional.ofNullable(menus.get(restaurant));
  }
}
