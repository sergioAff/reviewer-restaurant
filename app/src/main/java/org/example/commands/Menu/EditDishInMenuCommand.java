package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;

import org.example.controllers.MenuController;
import org.example.models.DishModel;

public class EditDishInMenuCommand implements ICommand {
  private final MenuController menuController;
  private final IConsoleHandler consoleHandler;

  public EditDishInMenuCommand(MenuController menuController, IConsoleHandler consoleHandler) {
    this.menuController = menuController;
    this.consoleHandler = consoleHandler;

  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish name:");
    String dishName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter updated dish name:");
    String updatedDishName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter updated dish description:");
    String updatedDishDescription = consoleHandler.readLine();
    consoleHandler.writeLine("Enter updated dish price:");
    Double updatedDishPrice = Double.parseDouble(consoleHandler.readLine());
    menuController.editDishInMenu(restaurantName, dishName, new DishModel(updatedDishName, updatedDishDescription, updatedDishPrice));
    consoleHandler.writeLine("Dish updated successfully.");
  }
}
