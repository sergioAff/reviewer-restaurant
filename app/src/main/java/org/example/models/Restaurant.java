package org.example.models;

public class Restaurant {
  private String name;
  private String address;
  private Menu menu;
  private Review[] reviews;
  private String owner;
  private Integer capacity;


  public Restaurant() {
  }

  public Restaurant(String name, String address, Menu menu, Review[] reviews, String owner, Integer capacity) {
    this.name = name;
    this.address = address;
    this.menu = menu;
    this.reviews = reviews;
    this.owner = owner;
    this.capacity = capacity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public Review[] getReviews() {
    return reviews;
  }

  public void setReviews(Review[] reviews) {
    this.reviews = reviews;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
}
