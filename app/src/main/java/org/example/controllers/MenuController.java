package org.example.controllers;

import org.example.models.Dish;
import org.example.models.Menu;
import org.example.models.Restaurant;
import org.example.services.MenuService;
import org.example.utils.ConsoleHandler;

public class MenuController {
  private final MenuService menuService;
  private final ConsoleHandler consoleHandler;

  public MenuController() {
    this.menuService = MenuService.getInstance();
    this.consoleHandler = new ConsoleHandler();
  }

  public void associateMenuToRestaurant(Restaurant restaurant) {
    consoleHandler.writeLine("Ingrese el nombre del menú a asociar:");
    String menuName = consoleHandler.readLine();

    Menu menu = new Menu();
    menu.setRestaurant(restaurant);

    if (menuService.associateMenuToRestaurant(restaurant, menu)) {
      consoleHandler.writeLine("Menú asociado exitosamente al restaurante.");
    } else {
      consoleHandler.writeLine("Error al asociar el menú.");
    }
  }

  public void addDishToMenu(Restaurant restaurant) {
    consoleHandler.writeLine("Ingrese el nombre del plato:");
    String dishName = consoleHandler.readLine();

    consoleHandler.writeLine("Ingrese la descripción del plato:");
    String dishDescription = consoleHandler.readLine();

    consoleHandler.writeLine("Ingrese el precio del plato:");
    double dishPrice = Double.parseDouble(consoleHandler.readLine());

    Dish dish = new Dish(dishName, dishDescription, dishPrice);

    if (menuService.addDishToMenu(restaurant, dish)) {
      consoleHandler.writeLine("Plato agregado exitosamente al menú.");
    } else {
      consoleHandler.writeLine("Error al agregar el plato al menú.");
    }
  }

  public void editDishInMenu(Restaurant restaurant) {
    consoleHandler.writeLine("Ingrese el nombre del plato a editar:");
    String dishName = consoleHandler.readLine();

    consoleHandler.writeLine("Ingrese la nueva descripción del plato:");
    String dishDescription = consoleHandler.readLine();

    consoleHandler.writeLine("Ingrese el nuevo precio del plato:");
    double dishPrice = Double.parseDouble(consoleHandler.readLine());

    Dish updatedDish = new Dish(dishName, dishDescription, dishPrice);

    if (menuService.editDishInMenu(restaurant, updatedDish)) {
      consoleHandler.writeLine("Plato editado exitosamente en el menú.");
    } else {
      consoleHandler.writeLine("Error al editar el plato en el menú.");
    }
  }

  public void deleteDishFromMenu(Restaurant restaurant) {
    consoleHandler.writeLine("Ingrese el nombre del plato a eliminar:");
    String dishName = consoleHandler.readLine();

    if (menuService.deleteDishFromMenu(restaurant, dishName)) {
      consoleHandler.writeLine("Plato eliminado exitosamente del menú.");
    } else {
      consoleHandler.writeLine("Error al eliminar el plato del menú.");
    }
  }
}
