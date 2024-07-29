package com.JobApp.JobApp.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>>  getAllReviews(@PathVariable Long companyId){
        List<Review> reviews =reviewService.getAllReviews(companyId);
        return reviews!= null ? new ResponseEntity<>(reviews , HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody  Review review ,
                          @PathVariable Long companyId){
        return  reviewService.AddReview(companyId, review) ? new ResponseEntity<>("Review Add Successfully" ,HttpStatus.OK):
                new ResponseEntity<>("Review not added maybe company doesn't exsit" ,HttpStatus.NOT_FOUND);


    }
    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                            @PathVariable Long reviewId){
        Review review=reviewService.getReview(companyId,reviewId);
        return  review!=null ? new ResponseEntity<>(review , HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
