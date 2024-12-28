package org.example.repositories;

import org.example.models.DishModel;
import org.example.models.DishReviewModel;
import org.example.models.MenuModel;
import org.example.models.RestaurantModel;
import org.example.Interface.observable.Observable;
import org.example.Interface.observable.Observer;
import org.example.models.RestaurantReviewModel;

import java.util.*;

public class DataRepository implements Observable {

  private static DataRepository instance;

  private final Map<String, RestaurantModel> restaurants;
  private final Map<String, DishModel> dishes;
  private final List<Observer> observers;

  private DataRepository() {
    this.restaurants = new HashMap<>();
    this.dishes = new HashMap<>();
    this.observers = new ArrayList<>();
  }

  public static DataRepository getInstance() {
    if (instance == null) {
      synchronized (DataRepository.class) {
        instance = new DataRepository();
      }
    }
    return instance;
  }

  public Double calculateAverageRatingRestaurant(String restaurant) {
    return restaurants.get(restaurant).getAverageRating();
  }

  public Double calculateAverageRatingDish(String dish) {
    return dishes.get(dish).getAverageRating();
  }

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

  public void addRestaurant(RestaurantModel restaurant) {
    Objects.requireNonNull(restaurant, "Restaurant cannot be null.");
    if (restaurants.containsKey(restaurant.getName())) {
      throw new IllegalArgumentException("Restaurant already exists: " + restaurant.getName());
    }
    restaurants.put(restaurant.getName(), restaurant);
    notifyObservers("New restaurant added: " + restaurant.getName());
  }

  public void updateRestaurant(RestaurantModel restaurant) {
    Objects.requireNonNull(restaurant, "Restaurant cannot be null.");
    if (!restaurants.containsKey(restaurant.getName())) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurant.getName());
    }
    restaurants.put(restaurant.getName(), restaurant);
    notifyObservers("Restaurant updated: " + restaurant.getName());
  }

  public RestaurantModel getRestaurant(String name) {
    return restaurants.get(name);
  }

  public List<RestaurantModel> getAllRestaurants() {
    return new ArrayList<>(restaurants.values());
  }

  public void removeRestaurant(String name) {
    if (!restaurants.containsKey(name)) {
      throw new IllegalArgumentException("Restaurant not found: " + name);
    }
    restaurants.remove(name);
    notifyObservers("Restaurant removed: " + name);
  }

  public void addDish(DishModel dish) {
    Objects.requireNonNull(dish, "Dish cannot be null.");
    if (dishes.containsKey(dish.getName())) {
      throw new IllegalArgumentException("Dish already exists: " + dish.getName());
    }
    dishes.put(dish.getName(), dish);
    notifyObservers("New dish added: " + dish.getName());
  }

  public DishModel getDish(String name) {
    return dishes.get(name);
  }

  public List<DishModel> getAllDishes(String restaurantName) {
    if (!restaurants.containsKey(restaurantName)) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurantName);
    }
    return restaurants.get(restaurantName).getMenu().getDishes();
  }

  public void addReviewToDish(DishReviewModel review) {
    DishModel dish = dishes.get(review.getDish().getName());
    if (dish == null) {
      throw new IllegalArgumentException("Dish not found: " + review.getDish().getName());
    }
    review.getDish().addReview(review);
    dishes.put(review.getDish().getName(), review.getDish());
    notifyObservers("New review added to dish: " + dish);
  }

  public void addReviewToRestaurant(RestaurantReviewModel review) {
    RestaurantModel restaurant = restaurants.get(review.getRestaurant().getName());
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant not found: " + review.getRestaurant().getName());
    }
    review.getRestaurant().addReview(review);
    restaurants.put(review.getRestaurant().getName(), review.getRestaurant());
    notifyObservers("New review added to restaurant: " + restaurant);
  }

  public void associateMenuToRestaurant(String restaurantName, MenuModel menu) {
    RestaurantModel restaurant = restaurants.get(restaurantName);
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant not found: " + restaurantName);
    }
    restaurant.setMenu(menu);
    notifyObservers("Menu associated with restaurant: " + restaurantName);
  }

  public void addDishToMenu(String restaurantName, DishModel dish) {
    RestaurantModel restaurant = restaurants.get(restaurantName);
    if (restaurant == null || restaurant.getMenu() == null || dishes.get(dish.getName()) == null) {
      throw new IllegalArgumentException("Restaurant, menu or dish not found: " + restaurantName);
    }
    restaurant.getMenu().addDish(dish);
    notifyObservers("Dish added to menu of restaurant: " + restaurantName);
  }

  public void editDishInMenu(String restaurantName, String dishName, DishModel updatedDish) {
    RestaurantModel restaurant = restaurants.get(restaurantName);
    if (restaurant == null || restaurant.getMenu() == null) {
      throw new IllegalArgumentException("Restaurant or menu not found: " + restaurantName);
    }
    MenuModel menu = restaurant.getMenu();
    List<DishModel> dishes = menu.getDishes();
    for (int i = 0; i < dishes.size(); i++) {
      if (dishes.get(i).getName().equals(dishName)) {
        dishes.set(i, updatedDish);
        notifyObservers("Dish updated in menu of restaurant: " + restaurantName);
        return;
      }
    }
    throw new IllegalArgumentException("Dish not found: " + dishName);
  }

  public void removeDishFromMenu(String restaurantName, String dishName) {
    RestaurantModel restaurant = restaurants.get(restaurantName);
    if (restaurant == null || restaurant.getMenu() == null) {
      throw new IllegalArgumentException("Restaurant or menu not found: " + restaurantName);
    }
    MenuModel menu = restaurant.getMenu();
    DishModel dishToRemove = null;
    for (DishModel dish : menu.getDishes()) {
      if (dish.getName().equals(dishName)) {
        dishToRemove = dish;
        break;
      }
    }
    if (dishToRemove != null) {
      menu.removeDish(dishToRemove);
      notifyObservers("Dish removed from menu of restaurant: " + restaurantName);
    } else {
      throw new IllegalArgumentException("Dish not found: " + dishName);
    }
  }
}