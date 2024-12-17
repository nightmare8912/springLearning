package com.emabrkx.FirstJobApp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(
            @PathVariable Long companyId
    ) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(
            @PathVariable Long companyId,
            @PathVariable Long reviewId
    ) {
        Review review = reviewService.getReview(companyId, reviewId);
        if (review != null)
            return  new ResponseEntity<>(review, HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(
            @PathVariable Long companyId,
            @RequestBody Review review
    ) {
        boolean added = reviewService.addReview(companyId, review);
        if (added)
            return new ResponseEntity<>(
                    "Review added successfully.",
                    HttpStatus.OK
            );
        return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);
    }
}
