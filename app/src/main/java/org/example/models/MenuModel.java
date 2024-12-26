package org.example.models;

import java.util.LinkedList;
import java.util.List;

public class MenuModel {
  private LinkedList<DishModel> DishModeles;
  private RestaurantModel RestaurantModel;

  public MenuModel(RestaurantModel RestaurantModel) {
    this.DishModeles = new LinkedList<>();
    this.RestaurantModel = RestaurantModel;
  }

  public List<DishModel> getDish() {
    return DishModeles;
  }

  public void setDish(LinkedList<DishModel> DishModeles) {
    this.DishModeles = DishModeles;
  }

  public RestaurantModel getRestaurant() {
    return RestaurantModel;
  }

  public void setRestaurant(RestaurantModel RestaurantModel) {
    this.RestaurantModel = RestaurantModel;
  }

  public void addDish(DishModel DishModel) {
    this.DishModeles.add(DishModel);
  }

  public void removeDish(DishModel DishModel) {
    this.DishModeles.remove(DishModel);
  }
}