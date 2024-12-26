package org.example;

import org.example.utils.AppMenu;
import org.example.utils.ConsoleHandler;
import org.example.Interface.IConsoleHandler;

public class Main {
  public static void main(String[] args) {
    IConsoleHandler consoleHandler = new ConsoleHandler();
    AppMenu appMenu = new AppMenu(consoleHandler);

    while (true) {
      appMenu.displayMenu();
      int option = Integer.parseInt(consoleHandler.readLine());
      appMenu.handleOption(option);
    }
  }
}