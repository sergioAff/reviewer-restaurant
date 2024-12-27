package org.example.services;

import org.example.models.DishModel;
import org.example.repositories.DataRepository;

import java.util.List;

public class DishService {
  private DataRepository repository;

  public DishService() {
    this.repository = DataRepository.getInstance();
  }

  public void createDish(String name, String description, double price) {
    if (repository.getDish(name) != null) {
      throw new IllegalArgumentException("Dish with this name already exists.");
    }
    DishModel dish = new DishModel(name, description, price);
    repository.addDish(dish);
  }

  public List<DishModel> getAllDishes() {
    return repository.getAllDishes();
  }

  public void updateDish(String name, String newDescription, double newPrice) {
    DishModel dish = repository.getDish(name);
    if (dish == null) {
      throw new IllegalArgumentException("Dish not found.");
    }
    dish.setDescription(newDescription);
    dish.setPrice(newPrice);
  }

  public void deleteDish(String name) {
    if (repository.getDish(name) == null) {
      throw new IllegalArgumentException("Dish not found.");
    }
    repository.removeDish(name);
  }
}
