package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReviewDto request, Store store) {
        return Review.builder()
                .store(store)
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDto toCreateResultDto(Review review) {
        return ReviewResponseDTO.CreateReviewResultDto.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .content(review.getContent())
                .rating(review.getRating())
                .createdAt(LocalDateTime.now().toString())
                .build();
    }
}

