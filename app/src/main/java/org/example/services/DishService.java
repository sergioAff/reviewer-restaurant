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
}