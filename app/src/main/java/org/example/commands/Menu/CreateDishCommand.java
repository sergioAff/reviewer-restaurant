package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.DishController;

public class CreateDishCommand implements ICommand {
  private final DishController dishController;
  private final IConsoleHandler consoleHandler;

  public CreateDishCommand(DishController dishController, IConsoleHandler consoleHandler) {
    this.dishController = dishController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter dish name:");
    String name = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish description:");
    String description = consoleHandler.readLine();
    consoleHandler.writeLine("Enter dish price:");
    double price = Double.parseDouble(consoleHandler.readLine());
    dishController.createDish(name, description, price);
    consoleHandler.writeLine("Dish created successfully.");
  }
}
