package org.example.utils;

import org.example.constants.MenuOption;
import org.example.controllers.DishController;
import org.example.controllers.MenuController;
import org.example.controllers.RestaurantController;
import org.example.controllers.DishReviewController;
import org.example.controllers.RestaurantReviewController;
import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;
import org.example.Interface.IConsoleHandler;

import java.util.List;

public class AppMenu {

  private final IConsoleHandler consoleHandler;
  private final DishController dishController;
  private final MenuController menuController;
  private final RestaurantController restaurantController;
  private final DishReviewController dishReviewController;
  private final RestaurantReviewController restaurantReviewController;

  public AppMenu(IConsoleHandler consoleHandler) {
    this.consoleHandler = consoleHandler;
    this.dishController = new DishController();
    this.menuController = new MenuController();
    this.restaurantController = new RestaurantController();
    this.dishReviewController = new DishReviewController();
    this.restaurantReviewController = new RestaurantReviewController();
  }

  public void displayMenu() {
    consoleHandler.writeLine("Menu Options:");
    consoleHandler.writeLine("1. Create Dish");
    consoleHandler.writeLine("2. Create Restaurant");
    consoleHandler.writeLine("3. Add Dish to Menu");
    consoleHandler.writeLine("4. Add Review to Dish");
    consoleHandler.writeLine("5. Add Review to Restaurant");
    consoleHandler.writeLine("6. View All Dishes");
    consoleHandler.writeLine("7. View All Restaurants");
    consoleHandler.writeLine("8. View Dish Reviews");
    consoleHandler.writeLine("9. View Restaurant Reviews");
    consoleHandler.writeLine("10. Exit");
    consoleHandler.writeLine("Select an option:");
  }

  public void handleOption(int option) {
    MenuOption menuOption = MenuOption.fromInt(option);
    switch (menuOption) {
      case CREATE_DISH:
        createDish();
        break;
      case CREATE_RESTAURANT:
        createRestaurant();
        break;
      case ADD_DISH_TO_MENU:
        addDishToMenu();
        break;
      case ADD_REVIEW_TO_DISH:
        addReviewToDish();
        break;
      case ADD_REVIEW_TO_RESTAURANT:
        addReviewToRestaurant();
        break;
      case VIEW_ALL_DISHES:
        viewAllDishes();
        break;
      case VIEW_ALL_RESTAURANTS:
        viewAllRestaurants();
        break;
      case VIEW_DISH_REVIEWS:
        viewDishReviews();
        break;
      case VIEW_RESTAURANT_REVIEWS:
        viewRestaurantReviews();
        break;
      case EXIT:
        consoleHandler.writeLine("Exiting application...");
        System.exit(0);
      default:
        throw new IllegalArgumentException("Invalid menu option");
    }
  }

  private void createDish() {
    consoleHandler.writeLine("Enter dish name:");
    String name = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish description:");
    String description = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish price:");
    double price = Double.parseDouble(consoleHandler.readLine());
    dishController.createDish(name, description, price);
    consoleHandler.writeLine("Dish created successfully.");
  }

  private void createRestaurant() {
    consoleHandler.writeLine("Enter restaurant name:");
    String name = consoleHandler.readLine();
    consoleHandler.writeLine("Enter restaurant address:");
    String address = consoleHandler.readLine();
    consoleHandler.writeLine("Is the restaurant available? (true/false):");
    boolean isAvailable = Boolean.parseBoolean(consoleHandler.readLine());
    restaurantController.createRestaurant(name, address, isAvailable);
    consoleHandler.writeLine("Restaurant created successfully.");
  }

  private void addDishToMenu() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish name:");
    String dishName = consoleHandler.readLine();
    DishModel dish = dishController.getDish(dishName);
    if (dish != null) {
      menuController.addDishToMenu(restaurantName, dish);
      consoleHandler.writeLine("Dish added to menu successfully.");
    } else {
      consoleHandler.writeLine("Dish not found.");
    }
  }

  private void addReviewToDish() {
    consoleHandler.writeLine("Enter dish name:");
    String dishName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter reviewer name:");
    String reviewerName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter rating:");
    int rating = Integer.parseInt(consoleHandler.readLine());
    consoleHandler.writeLine("Enter comment:");
    String comment = consoleHandler.readLine();
    dishReviewController.addReviewToDish(dishName, reviewerName, rating, comment);
    consoleHandler.writeLine("Review added to dish successfully.");
  }

  private void addReviewToRestaurant() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter reviewer name:");
    String reviewerName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter rating:");
    int rating = Integer.parseInt(consoleHandler.readLine());
    consoleHandler.writeLine("Enter comment:");
    String comment = consoleHandler.readLine();
    restaurantReviewController.addReviewToRestaurant(restaurantName, reviewerName, rating, comment);
    consoleHandler.writeLine("Review added to restaurant successfully.");
  }

  private void viewAllDishes() {
    List<DishModel> dishes = dishController.getAllDishes();
    if (dishes.isEmpty()) {
      consoleHandler.writeLine("No dishes found.");
    } else {
      dishes.forEach(dish -> consoleHandler.writeLine(dish.getName()));
    }
  }

  private void viewAllRestaurants() {
    List<RestaurantModel> restaurants = restaurantController.getAllRestaurants();
    if (restaurants.isEmpty()) {
      consoleHandler.writeLine("No restaurants found.");
    } else {
      restaurants.forEach(restaurant -> consoleHandler.writeLine(restaurant.getName()));
    }
  }

  private void viewDishReviews() {
    consoleHandler.writeLine("Enter dish name:");
    String dishName = consoleHandler.readLine();
    List<DishReviewModel> reviews = dishReviewController.getReviewsOfDish(dishName);
    if (reviews == null || reviews.isEmpty()) {
      consoleHandler.writeLine("No reviews found for this dish.");
    } else {
      reviews.forEach(review -> consoleHandler.writeLine(review.getComment()));
    }
  }

  private void viewRestaurantReviews() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    List<RestaurantReviewModel> reviews = restaurantReviewController.getReviewsOfRestaurant(restaurantName);
    if (reviews == null || reviews.isEmpty()) {
      consoleHandler.writeLine("No reviews found for this restaurant.");
    } else {
      reviews.forEach(review -> consoleHandler.writeLine(review.getComment()));
    }
  }
}