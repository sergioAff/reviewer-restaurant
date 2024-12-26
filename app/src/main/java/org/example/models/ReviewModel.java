package org.example.models;

public class ReviewModel {
  private String reviewerName;
  private int rating;
  private String comment;

  public ReviewModel(String reviewerName, int rating, String comment) {
    this.reviewerName = reviewerName;
    this.rating = rating;
    this.comment = comment;
  }

  public String getReviewerName() {
    return reviewerName;
  }

  public void setReviewerName(String reviewerName) {
    this.reviewerName = reviewerName;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}