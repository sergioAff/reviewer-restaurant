package org.example.commands.Restaurant;

import org.example.commands.Restaurants.ViewAllRestaurantsCommand;
import org.example.controllers.RestaurantController;
import org.example.Interface.IConsoleHandler;
import org.example.models.RestaurantModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class ListRestaurantReviewsCommandTest {

  private IConsoleHandler mockHandler;
  private RestaurantController mockRestaurantController;

  @BeforeEach
  void setup() {
    mockHandler = mock(IConsoleHandler.class);
    mockRestaurantController = mock(RestaurantController.class);
  }

  @Test
  @DisplayName("Test List Restaurant Reviews Command")
  void testListRestaurantReviews() {
    when(mockRestaurantController.getAllRestaurants()).thenReturn(List.of(new RestaurantModel("Restaurante 1", "Calle Ficticia 123", true)));

    ViewAllRestaurantsCommand command = new ViewAllRestaurantsCommand(mockRestaurantController, mockHandler);
    when(mockHandler.readLine()).thenReturn("Restaurante 1");

    command.execute();

    verify(mockHandler).writeLine("Ingrese el nombre del restaurante:");
    // AREGLAR AQUI verify(mockRestaurantController).getReviewsOfRestaurant("Restaurante 1");
  }
}