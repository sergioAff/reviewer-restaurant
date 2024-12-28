package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.MenuController;

public class DeleteDishFromMenuCommand implements ICommand {

  private final MenuController menuController;
  private final IConsoleHandler consoleHandler;
  public DeleteDishFromMenuCommand(MenuController menuController, IConsoleHandler consoleHandler) {
    this.menuController = menuController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish name:");
    String dishName = consoleHandler.readLine();
    menuController.removeDishFromMenu(restaurantName, dishName);
    consoleHandler.writeLine("Dish deleted from menu successfully.");
  }
}
