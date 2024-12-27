package org.example.services;

import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.repositories.DataRepository;
import org.example.utils.ReviewFactory;

import java.util.List;

public class DishService {
  private final DataRepository repository;
  private final ReviewFactory reviewFactory;

  public DishService() {
    this.repository = DataRepository.getInstance();
    this.reviewFactory = new ReviewFactory();
  }

  public void createDish(String name, String description, double price) {
    DishModel dish = new DishModel(name, description, price);
    repository.addDish(dish);
  }

  public List<DishModel> getAllDishes() {
    return repository.getAllDishes();
  }

  public void updateDish(String name, String newDescription, double newPrice) {
    DishModel dish = repository.getDish(name);
    if (dish != null) {
      dish.setDescription(newDescription);
      dish.setPrice(newPrice);
    }
  }

  public void deleteDish(String name) {
    repository.removeDish(name);
  }

  public void addReviewToDish(String dishName, String reviewerName, int rating, String comment) {
    DishModel dish = repository.getDish(dishName);
    if (dish != null) {
      reviewFactory.createReview("Dish", reviewerName, rating, comment, dish);
    }
  }

  public List<DishReviewModel> getReviewsOfDish(String dishName) {
    DishModel dish = repository.getDish(dishName);
    return dish != null ? dish.getReviews() : null;
  }

  public double getAverageRatingOfDish(String dishName) {
    DishModel dish = repository.getDish(dishName);
    return dish != null ? dish.getAverageRating() : 0.0;
  }
}
