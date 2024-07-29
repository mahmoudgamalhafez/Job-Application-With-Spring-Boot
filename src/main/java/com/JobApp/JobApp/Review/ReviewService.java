package com.JobApp.JobApp.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long CompanyId);
    Boolean AddReview(Long companyId ,Review review);
    Review getReview(Long companyId ,Long reviewId) ;

}
