package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.MenuController;

public class ViewDishByRestaurantCommand implements ICommand {
  private final MenuController menuController;
  private final IConsoleHandler consoleHandler;

  public ViewDishByRestaurantCommand(MenuController menuController, IConsoleHandler consoleHandler) {
    this.menuController = menuController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    menuController.getDishesInMenu(restaurantName);
  }
}
