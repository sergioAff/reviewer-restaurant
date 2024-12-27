package org.example.commands.Restaurants;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.RestaurantController;

public class EditRestaurantCommand implements ICommand {
  private final RestaurantController restaurantController;
  private final IConsoleHandler consoleHandler;

  public EditRestaurantCommand(RestaurantController restaurantController, IConsoleHandler consoleHandler) {
    this.restaurantController = restaurantController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name to edit:");
    String name = consoleHandler.readLine();
    consoleHandler.writeLine("Enter new address:");
    String newAddress = consoleHandler.readLine();
    consoleHandler.writeLine("Is the restaurant available? (true/false):");
    boolean newAvailability = Boolean.parseBoolean(consoleHandler.readLine());
    restaurantController.updateRestaurant(name, newAddress, newAvailability);
    consoleHandler.writeLine("Restaurant updated successfully.");
  }
}