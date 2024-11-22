package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.dto.reviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.AddReviewDTO request, Restaurant restaurant, Member member) {
        return Review.builder()
                .content(request.getContent())
                .title(request.getTitle())
                .rate(request.getRate())
                .restaurant(restaurant)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO.ReviewIdDTO toReviewIdDTO(Review review) {
        return ReviewResponseDTO.ReviewIdDTO.builder()
                .reviewId(review.getId())
                .build();
    }
}
