package org.example.commands.Restaurants;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.RestaurantController;

public class CreateRestaurantCommand implements ICommand {
  private final RestaurantController restaurantController;
  private final IConsoleHandler consoleHandler;

  public CreateRestaurantCommand(RestaurantController restaurantController, IConsoleHandler consoleHandler) {
    this.restaurantController = restaurantController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name:");
    String name = consoleHandler.readLine();
    consoleHandler.writeLine("Enter restaurant address:");
    String address = consoleHandler.readLine();
    consoleHandler.writeLine("Is the restaurant available? (true/false):");
    boolean isAvailable = Boolean.parseBoolean(consoleHandler.readLine());
    restaurantController.createRestaurant(name, address, isAvailable);
    consoleHandler.writeLine("Restaurant created successfully.");
  }
}
