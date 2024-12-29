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
  }

  @Test
  @DisplayName("Test Create Dish Review Command")
  void testCreateDishReview() {
    when(mockDish.getName()).thenReturn("Plato 1");
    CreateDishReviewCommand command = new CreateDishReviewCommand(mockDish, "Reviewer 1", 5.0, "Delicioso");

    command.execute();

    verify(mockDish).addReview(any());
    verify(mockReviewDishController).addReviewToDish("Plato 1", "Reviewer 1", 5.0, "Delicioso");
  }
}