package org.example.models;

import java.util.LinkedList;
import java.util.List;

public class MenuModel {
  private List<DishModel> dishes;
  private RestaurantModel restaurant;

  public MenuModel(RestaurantModel restaurant) {
    this.dishes = new LinkedList<>();
    this.restaurant = restaurant;
  }

  public DishModel findDishByName(String name) {
    for (DishModel dish : dishes) {
      if (dish.getName().equalsIgnoreCase(name)) {
        return dish;
      }
    }
    return null;
  }

  public List<DishModel> getDishes() {
    return dishes;
  }

  public void setDishes(List<DishModel> dishes) {
    this.dishes = dishes;
  }

  public RestaurantModel getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(RestaurantModel restaurant) {
    this.restaurant = restaurant;
  }

  public void addDish(DishModel dish) {
    this.dishes.add(dish);
  }

  public void removeDish(DishModel dish) {
    this.dishes.remove(dish);
  }
}
