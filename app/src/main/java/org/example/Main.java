package org.example;

import org.example.utils.AppMenu;
import org.example.utils.ConsoleHandler;
import org.example.Interface.IConsoleHandler;
import org.example.utils.HandleOption;

public class Main {
  public static boolean keepRunning = true;

  public static void main(String[] args) {
    IConsoleHandler consoleHandler = new ConsoleHandler();
    AppMenu appMenu = new AppMenu(consoleHandler);
    HandleOption handleOption = new HandleOption(consoleHandler);

    while (keepRunning) {
      appMenu.displayMenu();
      Integer option = Integer.parseInt(consoleHandler.readLine());
      handleOption.execute(option);
    }
  }
}