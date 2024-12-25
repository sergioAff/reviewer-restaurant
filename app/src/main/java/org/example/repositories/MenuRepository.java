package org.example.repositories;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MenuRepository {

  private static MenuRepository instance;
  private final Map<Restaurant, Menu> menus;

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
    if (menus.get(menu.getRestaurant()) != null) {
      menus.put(menu.getRestaurant(), menu);
      return true;
    }
    return false;
  }

  public Optional<Menu> getMenu(Restaurant restaurant) {
    return Optional.ofNullable(menus.get(restaurant));
  }

  public Boolean updateDishInMenu(Restaurant restaurant, Dish updatedDish) {
   if ( menus.get(restaurant) != null ) {
     Dish[] dishes = menus.get(restaurant).getDishes();
     for (int i = 0; i < dishes.length; i++) {
       if (dishes[i].getName().equals(updatedDish.getName())) {
         dishes[i] = updatedDish;
         return true;
       }
     }
   }
   return false;
  }

  public Boolean deleteDishFromMenu(Restaurant restaurant, String dishName) {
    if (menus.get(restaurant) != null) {
      Dish[] dishes = menus.get(restaurant).getDishes();
      Dish[] newDishes = new Dish[dishes.length - 1];
      int index = 0;
      for (Dish dish : dishes) {
        if (!dish.getName().equals(dishName)) {
          newDishes[index] = dish;
          index++;
        }
      }
      menus.get(restaurant).setDishes(newDishes);
      return true;
    }
    return false;
  }

  public Map<Restaurant, Menu> getAllMenus() {
    return new HashMap<>(menus);
  }
}
