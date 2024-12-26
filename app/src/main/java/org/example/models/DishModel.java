package org.example.models;

import org.example.observable.Observable;
import org.example.observable.Observer;

import java.util.LinkedList;
import java.util.List;

public class DishModel implements Observable {
  private String name;
  private String description;
  private double price;
  private LinkedList<DishReviewModel> reviews;
  private double averageRating;
  private List<Observer> observers;

  public DishModel(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.reviews = new LinkedList<>();
    this.averageRating = 0.0;
    this.observers = new LinkedList<>();
  }

  private void calculateAverageRating() {
    if (reviews.isEmpty()) {
      this.averageRating = 0.0;
    } else {
      double sum = 0.0;
      for (DishReviewModel review : reviews) {
        sum += review.getRating();
      }
      this.averageRating = sum / reviews.size();
    }
    notifyObservers();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public List<DishReviewModel> getReviews() {
    return reviews;
  }

  public void setReviews(LinkedList<DishReviewModel> reviews) {
    this.reviews = reviews;
    calculateAverageRating();
  }

  public double getAverageRating() {
    return averageRating;
  }

  public void addReview(DishReviewModel review) {
    this.reviews.add(review);
    calculateAverageRating();
  }

  public void removeReview(DishReviewModel review) {
    this.reviews.remove(review);
    calculateAverageRating();
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
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update();
    }
  }
}