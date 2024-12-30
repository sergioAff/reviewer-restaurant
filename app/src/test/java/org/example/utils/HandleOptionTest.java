package org.example.utils;

import org.example.Interface.IConsoleHandler;
import org.example.constants.MenuOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class HandleOptionTest {

  private HandleOption handleOption;
  private IConsoleHandler mockConsoleHandler;
  private ReviewFactory mockReviewFactory;

  @BeforeEach
  void setup() {
    mockConsoleHandler = mock(IConsoleHandler.class);
    mockReviewFactory = mock(ReviewFactory.class);
    handleOption = new HandleOption(mockConsoleHandler);
    handleOption.reviewFactory = mockReviewFactory; // Inject the mock review factory
  }

  @Test
  @DisplayName("Test Execute Add Review to Dish Option")
  void testExecuteAddReviewToDishOption() {
    when(mockConsoleHandler.readLine()).thenReturn("Reviewer 1", "5.0", "Excellent", "Dish 1");
    doNothing().when(mockReviewFactory).createReview(eq("Dish"), anyString(), anyDouble(), anyString(), any());

    handleOption.execute(MenuOption.ADD_REVIEW_TO_DISH.getOptionNumber());

    verify(mockReviewFactory).createReview(eq("Dish"), anyString(), anyDouble(), anyString(), any());
  }

  @Test
  @DisplayName("Test Execute Add Review to Restaurant Option")
  void testExecuteAddReviewToRestaurantOption() {
    when(mockConsoleHandler.readLine()).thenReturn("Reviewer 1", "5.0", "Excellent", "Restaurant 1");
    doNothing().when(mockReviewFactory).createReview(eq("Restaurant"), anyString(), anyDouble(), anyString(), any());

    handleOption.execute(MenuOption.ADD_REVIEW_TO_RESTAURANT.getOptionNumber());

    verify(mockReviewFactory).createReview(eq("Restaurant"), anyString(), anyDouble(), anyString(), any());
  }

  @Test
  @DisplayName("Test Execute Invalid Option")
  void testExecuteInvalidOption() {
    handleOption.execute(999); // Invalid option

    verify(mockConsoleHandler).writeLine("Opcion no encontrada");
  }
}