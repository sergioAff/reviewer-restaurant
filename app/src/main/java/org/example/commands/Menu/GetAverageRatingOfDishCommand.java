package org.example.commands.Menu;

import org.example.Interface.ICommand;
import org.example.Interface.IConsoleHandler;
import org.example.controllers.DishController;

public class GetAverageRatingOfDishCommand implements ICommand {
  private final IConsoleHandler consoleHandler;
  private final DishController dishController;

  public GetAverageRatingOfDishCommand(DishController dishController, IConsoleHandler consoleHandler) {
    this.dishController = dishController;
    this.consoleHandler = consoleHandler;
  }

  @Override
  public void execute() {
    consoleHandler.writeLine("Enter dish name:");
    String name = consoleHandler.readLine();
    double averageRating = dishController.getAverageRatingOfDish(name);
    consoleHandler.writeLine("Average rating of " + name + ": " + averageRating);
  }
}
