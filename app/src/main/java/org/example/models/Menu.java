package org.example.models;

public class Menu {
  private Restaurant restaurant;
  private Dish[] dishes;

  public Menu() {
  }

  public Menu(Restaurant restaurant, Dish[] dishes) {
    this.restaurant = restaurant;
    this.dishes = dishes;
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
}
