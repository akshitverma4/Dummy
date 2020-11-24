package com.example.Dummy.items;

public class Reviews {
    private  String mRatings;
    private String mReviewHead;
    private String mReviewBody;
    private String mReviewer;


    public Reviews(){}
    public Reviews(String Ratings, String Head, String Body, String Reviewer) {

            this.mRatings = Ratings;
            this.mReviewHead = Head;
            this.mReviewBody= Body;
            this.mReviewer = Reviewer;

    }

    public void setRatings(String Ratings) { this.mRatings= Ratings; }
    public void setReviewHead(String Head) { this.mReviewHead= Head; }
    public void setReviewBody(String Body) { this.mReviewBody= Body; }
    public void setReviewer(String Reviewer) { this.mReviewer= Reviewer; }



    public String getRatings() {
        return mRatings;
    }
    public String getReviewHead() {
        return mReviewHead;
    }
    public String getReviewBody() {
        return mReviewBody;
    }
    public String getReviewer() {
        return mReviewer;
    }

}