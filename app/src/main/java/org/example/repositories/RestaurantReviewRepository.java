package org.example.repositories;

import org.example.models.Restaurant;
import org.example.models.Review;

import java.util.HashMap;
import java.util.Map;

public class RestaurantReviewRepository {
  private static RestaurantReviewRepository instance;
  private Map<Restaurant, Review[]> reviews;

  private RestaurantReviewRepository() {
  this.reviews=new HashMap<>();
  }

  public static synchronized RestaurantReviewRepository getInstance() {
    if (instance == null) {
      instance = new RestaurantReviewRepository();
    }
    return instance;
  }

  public Boolean addReview(Restaurant restaurant, Review review) {
    if (reviews.get(restaurant) != null) {
      Review[] reviewArray = reviews.get(restaurant);
      Review[] newReviewArray = new Review[reviewArray.length + 1];
      for (int i = 0; i < reviewArray.length; i++) {
        newReviewArray[i] = reviewArray[i];
      }
      newReviewArray[reviewArray.length] = review;
      reviews.put(restaurant, newReviewArray);
      return true;
    }
    return false;
  }

  public Review[] getReviews(Restaurant restaurant) {
    return reviews.get(restaurant);
  }

  public Boolean deleteReview(Restaurant restaurant, Review review) {
    if (reviews.get(restaurant) != null) {
      Review[] reviewArray = reviews.get(restaurant);
      Review[] newReviewArray = new Review[reviewArray.length - 1];
      int index = 0;
      for (Review r : reviewArray) {
        if (r != review) {
          newReviewArray[index] = r;
          index++;
        }
      }
      reviews.put(restaurant, newReviewArray);
      return true;
    }
    return false;
  }

}
