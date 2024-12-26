package org.example.constants;

public enum MenuOption {
  ADD_RESTAURANT(1, "Agregar Restaurante"),
  EDIT_RESTAURANT(2, "Editar Restaurante"),
  DELETE_RESTAURANT(3, "Eliminar Restaurante"),
  LIST_RESTAURANTS(4, "Listar Restaurantes"),
  ASSOCIATE_MENU(5, "Asociar Menú a Restaurante"),
  ADD_DISH(6, "Añadir Plato a Menú"),
  EDIT_DISH(7, "Editar Plato en Menú"),
  DELETE_DISH(8, "Eliminar Plato de Menú"),
  CREATE_REVIEW(9, "Crear Review de Restaurante"),
  LIST_REVIEWS(10, "Listar Reviews de Restaurante"),
  CALCULATE_AVERAGE_RATING(11, "Calcular Calificación Promedio de Restaurante"),
  CREATE_DISH_REVIEW(12, "Crear Review de Plato"),
  LIST_DISH_REVIEWS(13, "Listar Reviews de Plato"),
  CALCULATE_DISH_AVERAGE_RATING(14, "Calcular Calificación Promedio de Plato"),
  EXIT(15, "Salir");

  private final int optionNumber;
  private final String description;

  MenuOption(int optionNumber, String description) {
    this.optionNumber = optionNumber;
    this.description = description;
  }

  public int getOptionNumber() {
    return optionNumber;
  }

  public String getDescription() {
    return description;
  }

  public static MenuOption fromOptionNumber(int optionNumber) {
    for (MenuOption option : values()) {
      if (option.optionNumber == optionNumber) {
        return option;
      }
    }
    throw new IllegalArgumentException("Opción inválida: " + optionNumber);
  }
}