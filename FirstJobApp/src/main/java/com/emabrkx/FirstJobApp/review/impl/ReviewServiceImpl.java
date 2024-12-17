package com.emabrkx.FirstJobApp.review.impl;

import com.emabrkx.FirstJobApp.company.Company;
import com.emabrkx.FirstJobApp.company.CompanyService;
import com.emabrkx.FirstJobApp.review.Review;
import com.emabrkx.FirstJobApp.review.ReviewRepository;
import com.emabrkx.FirstJobApp.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    @Autowired
    public ReviewServiceImpl(
            ReviewRepository reviewRepository,
            CompanyService companyService
            ) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> allReviews = getAllReviews(companyId);
        for (Review review: allReviews) {
            if (review.getId().equals(reviewId))
                return review;
        }
        return null;
    }
}
