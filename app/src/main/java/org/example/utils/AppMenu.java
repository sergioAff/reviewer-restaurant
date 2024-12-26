package org.example.utils;

import org.example.Interface.IConsoleHandler;
import org.example.constants.MenuOption;
import org.example.controllers.MenuController;
import org.example.controllers.RestaurantController;
import org.example.controllers.ReviewController;
import org.example.models.Dish;
import org.example.models.Restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class AppMenu {
  private MenuOption option;
  private final IConsoleHandler console;
  private final RestaurantController restaurantController;
  private final MenuController menuController;
  private final ReviewController reviewController;
  private final ReviewDishController reviewDishController;
  private final Map<MenuOption, Consumer<Void>> actions;

  public AppMenu() {
    this.console = new ConsoleHandler();
    this.restaurantController = new RestaurantController();
    this.menuController = new MenuController();
    this.reviewController = new ReviewController();
    this.reviewDishController = new ReviewDishController();
    this.actions = new HashMap<>();
    initializeActions();
  }

  private void initializeActions() {
    initializeRestaurantActions();
    initializeMenuActions();
    initializeReviewActions();
    initializeDishReviewActions();
    actions.put(MenuOption.EXIT, v -> console.writeLine("Saliendo del menú..."));
  }

  private void initializeRestaurantActions() {
    actions.put(MenuOption.ADD_RESTAURANT, v -> restaurantController.addRestaurant());
    actions.put(MenuOption.EDIT_RESTAURANT, v -> restaurantController.updateRestaurant());
    actions.put(MenuOption.DELETE_RESTAURANT, v -> restaurantController.deleteRestaurant());
    actions.put(MenuOption.LIST_RESTAURANTS, v -> restaurantController.listRestaurants());
  }

  private void initializeMenuActions() {
    actions.put(MenuOption.ASSOCIATE_MENU, v -> {
      Restaurant restaurant = readRestaurant();
      menuController.associateMenuToRestaurant(restaurant);
    });
    actions.put(MenuOption.ADD_DISH, v -> {
      Restaurant restaurant = readRestaurant();
      menuController.addDishToMenu(restaurant);
    });
    actions.put(MenuOption.EDIT_DISH, v -> {
      Restaurant restaurant = readRestaurant();
      menuController.editDishInMenu(restaurant);
    });
    actions.put(MenuOption.DELETE_DISH, v -> {
      Restaurant restaurant = readRestaurant();
      menuController.deleteDishFromMenu(restaurant);
    });
  }

  private void initializeReviewActions() {
    actions.put(MenuOption.CREATE_REVIEW, v -> {
      Restaurant restaurant = readRestaurant();
      reviewController.createReview(restaurant);
    });
    actions.put(MenuOption.LIST_REVIEWS, v -> {
      Restaurant restaurant = readRestaurant();
      reviewController.listReviews(restaurant);
    });
    actions.put(MenuOption.CALCULATE_AVERAGE_RATING, v -> {
      Restaurant restaurant = readRestaurant();
      reviewController.calculateAverageRating(restaurant);
    });
  }

  private void initializeDishReviewActions() {
    actions.put(MenuOption.CREATE_DISH_REVIEW, v -> {
      Dish dish = readDish();
      reviewDishController.createReview(dish);
    });
    actions.put(MenuOption.LIST_DISH_REVIEWS, v -> {
      Dish dish = readDish();
      reviewDishController.listReviews(dish);
    });
    actions.put(MenuOption.CALCULATE_DISH_AVERAGE_RATING, v -> {
      Dish dish = readDish();
      reviewDishController.calculateAverageRating(dish);
    });
  }

  private Restaurant readRestaurant() {
    console.writeLine("Ingrese el nombre del restaurante:");
    String restaurantName = console.readLine();
    Restaurant restaurant = new Restaurant();
    restaurant.setName(restaurantName);
    return restaurant;
  }

  private Dish readDish() {
    console.writeLine("Ingrese el nombre del plato:");
    String dishName = console.readLine();
    Dish dish = new Dish();
    dish.setName(dishName);
    return dish;
  }

  public void execute() {
    do {
      console.writeLine("\n=== Menú Principal ===");
      for (MenuOption menuOption : MenuOption.values()) {
        console.writeLine(menuOption.getOptionNumber() + ". " + menuOption.getDescription());
      }
      console.writeLine("Seleccione una opción:");
      try {
        option = MenuOption.fromOptionNumber(Integer.parseInt(console.readLine()));
      } catch (IllegalArgumentException e) {
        console.writeLine("Opción inválida. Intente nuevamente.");
        continue;
      }

      actions.getOrDefault(option, v -> console.writeLine("Opción no reconocida. Intente nuevamente.")).accept(null);
    } while (option != MenuOption.EXIT);
  }
}