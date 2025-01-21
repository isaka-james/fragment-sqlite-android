package com.isaka.dineview.models;

public class Review {
    private int id;
    private String reviewTitle;
    private String reviewContent;

    // Constructor
    public Review(int id, String reviewTitle, String reviewContent) {
        this.id = id;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    // toString method (optional)
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}
