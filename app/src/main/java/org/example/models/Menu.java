package org.example.models;

public class Menu {
  private Restaurant restaurant;
  private Dish[] dishes;
  private String[] categories;

  public Menu() {
  }

  public Menu(Restaurant restaurant, Dish[] dishes, String[] categories) {
    this.restaurant = restaurant;
    this.dishes = dishes;
    this.categories = categories;
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public Dish[] getDishes() {
    return dishes;
  }

  public void setDishes(Dish[] dishes) {
    this.dishes = dishes;
  }

  public String[] getCategories() {
    return categories;
  }

  public void setCategories(String[] categories) {
    this.categories = categories;
  }
}
