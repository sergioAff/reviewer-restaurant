package org.example.commands.Restaurants;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.RestaurantController;
import org.example.models.RestaurantModel;

import java.util.List;

public class ViewAllRestaurantsCommand implements ICommand {
  private final RestaurantController restaurantController;
  private final IConsoleHandler consoleHandler;

  public ViewAllRestaurantsCommand(RestaurantController restaurantController, IConsoleHandler consoleHandler) {
    this.restaurantController = restaurantController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    List<RestaurantModel> restaurants = restaurantController.getAllRestaurants();
    if (restaurants.isEmpty()) {
      consoleHandler.writeLine("No restaurants found.");
    } else {
      for (RestaurantModel restaurant : restaurants) {
        consoleHandler.writeLine("Name: " + restaurant.getName() + ", Address: " + restaurant.getAddress() + ", Available: " + restaurant.isAvailable());
      }
    }
  }
}