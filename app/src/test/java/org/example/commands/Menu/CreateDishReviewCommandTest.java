package org.example.commands.Menu;

import org.example.models.DishModel;
import org.example.controllers.DishReviewController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CreateDishReviewCommandTest {

  private DishModel mockDish;
  private DishReviewController mockReviewDishController;

  @BeforeEach
  void setup() {
    mockDish = mock(DishModel.class);
    mockReviewDishController = mock(DishReviewController.class);
    when(mockDish.getName()).thenReturn("Plato 1");
    doNothing().when(mockReviewDishController).addReviewToDish(anyString(), anyString(), anyDouble(), anyString());
    // Ensure the dish exists in the mock controller
    doAnswer(invocation -> {
      String dishName = invocation.getArgument(0);
      if (!"Plato 1".equals(dishName)) {
        throw new IllegalArgumentException("Plato no encontrado: " + dishName);
      }
      return null;
    }).when(mockReviewDishController).addReviewToDish(anyString(), anyString(), anyDouble(), anyString());
  }

  @Test
  @DisplayName("Test Create Dish Review Command")
  void testCreateDishReview() {
    CreateDishReviewCommand command = new CreateDishReviewCommand(mockDish, "Reviewer 1", 5.0, "Delicioso");

    // Inject the mock controller into the command using reflection
    try {
      java.lang.reflect.Field field = CreateDishReviewCommand.class.getDeclaredField("dishReviewController");
      field.setAccessible(true);
      field.set(command, mockReviewDishController);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }

    command.execute();

    verify(mockDish).addReview(any());
    verify(mockReviewDishController).addReviewToDish("Plato 1", "Reviewer 1", 5.0, "Delicioso");
  }
}