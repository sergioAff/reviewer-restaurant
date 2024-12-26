package org.example.constants;

public enum MenuOption {
  CREATE_DISH,
  CREATE_RESTAURANT,
  ADD_DISH_TO_MENU,
  ADD_REVIEW_TO_DISH,
  ADD_REVIEW_TO_RESTAURANT,
  VIEW_ALL_DISHES,
  VIEW_ALL_RESTAURANTS,
  VIEW_DISH_REVIEWS,
  VIEW_RESTAURANT_REVIEWS,
  EXIT;

  public static MenuOption fromInt(int option) {
    return switch (option) {
      case 1 -> CREATE_DISH;
      case 2 -> CREATE_RESTAURANT;
      case 3 -> ADD_DISH_TO_MENU;
      case 4 -> ADD_REVIEW_TO_DISH;
      case 5 -> ADD_REVIEW_TO_RESTAURANT;
      case 6 -> VIEW_ALL_DISHES;
      case 7 -> VIEW_ALL_RESTAURANTS;
      case 8 -> VIEW_DISH_REVIEWS;
      case 9 -> VIEW_RESTAURANT_REVIEWS;
      case 10 -> EXIT;
      default -> throw new IllegalArgumentException("Invalid menu option");
    };
  }
}