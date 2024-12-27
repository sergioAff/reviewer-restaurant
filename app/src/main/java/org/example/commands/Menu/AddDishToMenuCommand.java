package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.DishController;
import org.example.controllers.MenuController;
import org.example.models.DishModel;

public class AddDishToMenuCommand implements ICommand {
  private final MenuController menuController;
  private final DishController dishController;
  private final IConsoleHandler consoleHandler;

  public AddDishToMenuCommand(MenuController menuController, DishController dishController, IConsoleHandler consoleHandler) {
    this.menuController = menuController;
    this.dishController = dishController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish name:");
    String dishName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish description:");
    String dishDescription = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish price:");
    double dishPrice = Double.parseDouble(consoleHandler.readLine());

    DishModel dish = new DishModel(dishName, dishDescription, dishPrice);
    menuController.addDishToMenu(restaurantName, dish);
    consoleHandler.writeLine("Dish added to menu successfully.");
  }
}