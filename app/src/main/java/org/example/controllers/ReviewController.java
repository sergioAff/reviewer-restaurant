package org.example.controllers;

import org.example.models.Restaurant;
import org.example.models.Review;
import org.example.services.ReviewService;
import org.example.utils.ConsoleHandler;
import org.example.Interface.IConsoleHandler;

import java.util.LinkedList;

public class ReviewController {
  private final ReviewService reviewService;
  private final IConsoleHandler consoleHandler;

  public ReviewController() {
    this.reviewService = ReviewService.getInstance();
    this.consoleHandler = new ConsoleHandler();
  }

  public void createReview(Restaurant restaurant) {
    consoleHandler.writeLine("Ingrese la calificación (0.0 - 5.0):");
    double rating = Double.parseDouble(consoleHandler.readLine());

    consoleHandler.writeLine("Ingrese el comentario:");
    String comment = consoleHandler.readLine();

    reviewService.createReview(restaurant, rating, comment);
    consoleHandler.writeLine("Review creada exitosamente.");
  }

  public void listReviews(Restaurant restaurant) {
    LinkedList<Review> reviews = reviewService.listReviews(restaurant);
    if (reviews.isEmpty()) {
      consoleHandler.writeLine("No hay reviews para este restaurante.");
    } else {
      reviews.forEach(review -> consoleHandler.writeLine(
        "Calificación: " + review.getRating() + ", Comentario: " + review.getComment()
      ));
    }
  }

  public void calculateAverageRating(Restaurant restaurant) {
    double averageRating = reviewService.calculateAverageRating(restaurant);
    consoleHandler.writeLine("La calificación promedio del restaurante es: " + averageRating);
  }
}