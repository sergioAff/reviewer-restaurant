package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.MenuController;

public class AssociateMenuToRestaurantCommand implements ICommand {
  private final MenuController menuController;
  private final IConsoleHandler consoleHandler;

  public AssociateMenuToRestaurantCommand(MenuController menuController, IConsoleHandler consoleHandler) {
    this.menuController = menuController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter restaurant name:");
    String restaurantName = consoleHandler.readLine();
    consoleHandler.writeLine("Enter menu name:");
    String menuName = consoleHandler.readLine();
    menuController.associateMenuToRestaurant(restaurantName, menuName);
    consoleHandler.writeLine("Menu associated to restaurant successfully.");
  }
}
