package com.JobApp.JobApp.Review.Impl;


import com.JobApp.JobApp.Company.Company;
import com.JobApp.JobApp.Company.CompanyService;
import com.JobApp.JobApp.Review.Review;
import com.JobApp.JobApp.Review.ReviewRepository;
import com.JobApp.JobApp.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepository reviewRepository ;
    private CompanyService companyService ;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Boolean AddReview(Long companyId, Review review) {
        Company company =companyService.getCompanyById(companyId);
        if(company!=null)
        {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }
}
