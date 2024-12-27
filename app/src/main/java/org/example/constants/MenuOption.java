package org.example.constants;

public enum MenuOption {
  CREATE_DISH(1, "Create Dish"),
  CREATE_RESTAURANT(2, "Create Restaurant"),
  ADD_DISH_TO_MENU(3, "Add Dish to Menu"),
  ADD_REVIEW_TO_DISH(4, "Add Review to Dish"),
  ADD_REVIEW_TO_RESTAURANT(5, "Add Review to Restaurant"),
  VIEW_ALL_DISHES(6, "View All Dishes"),
  VIEW_ALL_RESTAURANTS(7, "View All Restaurants"),
  VIEW_DISH_REVIEWS(8, "View Dish Reviews"),
  VIEW_RESTAURANT_REVIEWS(9, "View Restaurant Reviews"),
  EDIT_RESTAURANT(10, "Edit Restaurant"),
  DELETE_RESTAURANT(11, "Delete Restaurant"),
  EXIT(12, "Exit");

  private final int optionNumber;
  private final String description;

  MenuOption(int optionNumber, String description) {
    this.optionNumber = optionNumber;
    this.description = description;
  }

  public int getOptionNumber() {
    return optionNumber;
  }

  public String getDescription() {
    return description;
  }

  public static MenuOption fromInt(int option) {
    for (MenuOption menuOption : values()) {
      if (menuOption.optionNumber == option) {
        return menuOption;
      }
    }
    throw new IllegalArgumentException("Invalid menu option");
  }
}