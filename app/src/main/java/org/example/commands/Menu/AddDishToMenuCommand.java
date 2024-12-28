package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;

import org.example.controllers.MenuController;
import org.example.models.DishModel;

public class AddDishToMenuCommand implements ICommand {
  private final MenuController menuController;
  private final IConsoleHandler consoleHandler;

  public AddDishToMenuCommand(MenuController menuController, IConsoleHandler consoleHandler) {
    this.menuController = menuController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish name:");
    String dishName = consoleHandler.readLine();

    DishModel dish = new DishModel(dishName, "", 0.0);
    menuController.addDishToMenu(restaurantName, dish);
    consoleHandler.writeLine("Dish added to menu successfully.");
  }
}