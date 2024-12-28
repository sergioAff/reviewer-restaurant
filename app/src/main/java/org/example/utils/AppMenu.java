package org.example.utils;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.commands.Menu.AddDishToMenuCommand;
import org.example.commands.Menu.AssociateMenuToRestaurantCommand;
import org.example.commands.Menu.CreateDishCommand;
import org.example.commands.Menu.DeleteDishFromMenuCommand;
import org.example.commands.Menu.EditDishInMenuCommand;
import org.example.commands.Menu.GetAverageRatingOfDishCommand;
import org.example.commands.Menu.ViewDishByRestaurantCommand;
import org.example.commands.Menu.ViewDishReviewsCommand;
import org.example.commands.Restaurants.CreateRestaurantCommand;
import org.example.commands.Restaurants.DeleteRestaurantCommand;
import org.example.commands.Restaurants.EditRestaurantCommand;
import org.example.commands.Restaurants.GetAverageRatingOfRestaurantCommand;
import org.example.commands.Restaurants.ViewAllRestaurantsCommand;
import org.example.commands.Restaurants.ViewRestaurantReviewsCommand;
import org.example.constants.MenuOption;
import org.example.controllers.DishController;
import org.example.controllers.DishReviewController;
import org.example.controllers.MenuController;
import org.example.controllers.RestaurantController;
import org.example.controllers.RestaurantReviewController;
import org.example.models.DishModel;
import org.example.models.RestaurantModel;

import java.util.HashMap;
import java.util.Map;

public class AppMenu {
  private final IConsoleHandler consoleHandler;
  private final Map<MenuOption, ICommand> commandMap;
  private final ReviewFactory reviewFactory;

  public AppMenu(IConsoleHandler consoleHandler) {
    this.consoleHandler = consoleHandler;
    this.reviewFactory = new ReviewFactory();
    DishController dishController = new DishController();
    RestaurantController restaurantController = new RestaurantController();
    MenuController menuController = new MenuController();
    DishReviewController dishReviewController = new DishReviewController();
    RestaurantReviewController restaurantReviewController = new RestaurantReviewController();

    commandMap = new HashMap<>();
    commandMap.put(MenuOption.CREATE_DISH, new CreateDishCommand(dishController, consoleHandler));
    commandMap.put(MenuOption.CREATE_RESTAURANT, new CreateRestaurantCommand(restaurantController, consoleHandler));
    commandMap.put(MenuOption.ADD_DISH_TO_MENU, new AddDishToMenuCommand(menuController, consoleHandler));
    commandMap.put(MenuOption.VIEW_ALL_RESTAURANTS, new ViewAllRestaurantsCommand(restaurantController, consoleHandler));
    commandMap.put(MenuOption.VIEW_DISH_REVIEWS, new ViewDishReviewsCommand(dishReviewController, consoleHandler));
    commandMap.put(MenuOption.VIEW_RESTAURANT_REVIEWS, new ViewRestaurantReviewsCommand(restaurantReviewController, consoleHandler));
    commandMap.put(MenuOption.EDIT_RESTAURANT, new EditRestaurantCommand(restaurantController, consoleHandler));
    commandMap.put(MenuOption.DELETE_RESTAURANT, new DeleteRestaurantCommand(restaurantController, consoleHandler));
    commandMap.put(MenuOption.ASOCIATE_MENU_TO_RESTAURANT, new AssociateMenuToRestaurantCommand(menuController, consoleHandler));
    commandMap.put(MenuOption.EDIT_DISH, new EditDishInMenuCommand(menuController, consoleHandler));
    commandMap.put(MenuOption.DELETE_DISH, new DeleteDishFromMenuCommand(menuController, consoleHandler));
    commandMap.put(MenuOption.VIEW_ALL_DISHES_MENU, new ViewDishByRestaurantCommand(menuController, consoleHandler));
    commandMap.put(MenuOption.AVERAGE_RATING_OF_DISH, new GetAverageRatingOfDishCommand(dishController, consoleHandler));
    commandMap.put(MenuOption.AVERAGE_RATING_OF_RESTAURANT, new GetAverageRatingOfRestaurantCommand(restaurantController, consoleHandler));
  }

  public void displayMenu() {
    consoleHandler.writeLine("Menu Options:");
    for (MenuOption option : MenuOption.values()) {
      consoleHandler.writeLine(option.getOptionNumber() + ". " + option.getDescription());
    }
    consoleHandler.writeLine("Select an option:");
  }

  public void handleOption(int option) {
    try {
      MenuOption menuOption = MenuOption.fromInt(option);
      if (menuOption == MenuOption.ADD_REVIEW_TO_DISH || menuOption == MenuOption.ADD_REVIEW_TO_RESTAURANT) {
        createReview(menuOption);
      } else {
        ICommand command = commandMap.get(menuOption);
        if (command != null) {
          command.execute();
        } else if (menuOption == MenuOption.EXIT) {
          consoleHandler.writeLine("Exiting application...");
          System.exit(0);
        } else {
          throw new IllegalArgumentException("Invalid menu option");
        }
      }
    } catch (IllegalArgumentException e) {
      consoleHandler.writeLine(e.getMessage());
    }
  }

  private void createReview(MenuOption menuOption) {
    consoleHandler.writeLine("Enter reviewer name:");
    String reviewerName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter rating:");
    Double rating = Double.parseDouble(consoleHandler.readLine());
    consoleHandler.writeLine("Enter comment:");
    String comment = consoleHandler.readLine();

    if (menuOption == MenuOption.ADD_REVIEW_TO_DISH) {
      consoleHandler.writeLine("Enter dish name:");
      String dishName = consoleHandler.readLine();
      DishModel dish = new DishModel(dishName, "", 0.0); // Assuming a simple constructor for DishModel
      reviewFactory.createReview("Dish", reviewerName, rating, comment, dish);
    } else if (menuOption == MenuOption.ADD_REVIEW_TO_RESTAURANT) {
      consoleHandler.writeLine("Enter restaurant name:");
      String restaurantName = consoleHandler.readLine();
      RestaurantModel restaurant = new RestaurantModel(restaurantName, "", true); // Assuming a simple constructor for RestaurantModel
      reviewFactory.createReview("Restaurant", reviewerName, rating, comment, restaurant);
    }
  }
}