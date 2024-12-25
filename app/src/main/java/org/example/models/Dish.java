package org.example.models;

public class Dish {
  private String name;
  private String description;
  private Double price;

  public Dish() {
  }

  public Dish(String name, String description, Double price) {
    this.name = name;

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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
