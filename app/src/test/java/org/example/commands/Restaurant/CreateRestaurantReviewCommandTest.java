package org.example.commands.Restaurant;

import org.example.commands.Restaurants.CreateRestaurantReviewCommand;
import org.example.models.RestaurantModel;
import org.example.models.RestaurantReviewModel;
import org.example.controllers.RestaurantReviewController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CreateRestaurantReviewCommandTest {

  private RestaurantModel mockRestaurant;
  private RestaurantReviewController mockReviewController;

  @BeforeEach
  void setup() {
    mockRestaurant = mock(RestaurantModel.class);
    mockReviewController = mock(RestaurantReviewController.class);
  }

  @Test
  @DisplayName("Test Create Restaurant Review Command")
  void testCreateRestaurantReview() {
    String reviewerName = "Juan Pérez";
    Double rating = 4.5;
    String comment = "Excelente comida y servicio.";

    CreateRestaurantReviewCommand command = new CreateRestaurantReviewCommand(mockRestaurant, reviewerName, rating, comment);

    command.execute();

    RestaurantReviewModel expectedReview = new RestaurantReviewModel(reviewerName, rating, comment, mockRestaurant);

    verify(mockRestaurant).addReview(expectedReview);
    verify(mockReviewController).addReviewToRestaurant(
      mockRestaurant.getName(),
      expectedReview.getReviewerName(),
      expectedReview.getRating(),
      expectedReview.getComment()
    );
  }
}