package com.emabrkx.FirstJobApp.review;

import com.emabrkx.FirstJobApp.company.Company;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
}
