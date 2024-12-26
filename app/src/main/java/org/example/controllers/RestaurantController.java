package org.example.controllers;

import org.example.models.Restaurant;
import org.example.services.RestaurantService;
import org.example.utils.ConsoleHandler;
import org.example.Interface.IConsoleHandler;


import java.util.LinkedList;
import java.util.Map;

public class RestaurantController {
  private final RestaurantService service;
  private final IConsoleHandler console;

  public RestaurantController() {
    this.service = RestaurantService.getInstance();
    this.console = new ConsoleHandler();
  }

  public void addRestaurant() {
    console.writeLine("\n=== Agregar Restaurante ===");
    console.writeLine("Ingrese el nombre del restaurante:");
    String name = console.readLine();

    console.writeLine("Ingrese la dirección del restaurante:");
    String address = console.readLine();

    console.writeLine("Ingrese el propietario del restaurante:");
    String owner = console.readLine();

    console.writeLine("Ingrese la capacidad del restaurante:");
    Integer capacity = Integer.parseInt(console.readLine());

    Restaurant restaurant = new Restaurant(name, address, null, new LinkedList<>(), owner, capacity);
    if (service.addRestaurant(restaurant)) {
      console.writeLine("Restaurante agregado exitosamente.");
    } else {
      console.writeLine("Error al agregar el restaurante.");
    }
  }

  public void updateRestaurant() {
    console.writeLine("\n=== Editar Restaurante ===");
    console.writeLine("Ingrese el nombre del restaurante a editar:");
    String name = console.readLine();

    console.writeLine("Ingrese la nueva dirección del restaurante:");
    String address = console.readLine();

    console.writeLine("Ingrese el nuevo propietario del restaurante:");
    String owner = console.readLine();

    console.writeLine("Ingrese la nueva capacidad del restaurante:");
    Integer capacity = Integer.parseInt(console.readLine());

    Restaurant restaurant = new Restaurant(name, address, null, new LinkedList<>(), owner, capacity);
    if (service.updateRestaurant(restaurant)) {
      console.writeLine("Restaurante actualizado exitosamente.");
    } else {
      console.writeLine("Error al actualizar el restaurante. Asegúrese de que el restaurante existe.");
    }
  }

  public void deleteRestaurant() {
    console.writeLine("\n=== Eliminar Restaurante ===");
    console.writeLine("Ingrese el nombre del restaurante a eliminar:");
    String name = console.readLine();

    if (service.deleteRestaurant(name)) {
      console.writeLine("Restaurante eliminado exitosamente.");
    } else {
      console.writeLine("Error al eliminar el restaurante. Asegúrese de que el restaurante existe.");
    }
  }

  public void listRestaurants() {
    console.writeLine("\n=== Lista de Restaurantes ===");
    Map<String, Restaurant> restaurants = service.getAllRestaurants();

    if (restaurants.isEmpty()) {
      console.writeLine("No hay restaurantes disponibles.");
    } else {
      restaurants.forEach((key, restaurant) -> console.writeLine(
        "Nombre: " + restaurant.getName() + ", Dirección: " + restaurant.getAddress() + ", Propietario: " + restaurant.getOwner() + ", Capacidad: " + restaurant.getCapacity()
      ));
    }
  }
}
