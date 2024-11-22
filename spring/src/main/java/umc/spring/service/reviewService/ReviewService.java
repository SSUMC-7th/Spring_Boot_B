package umc.spring.service.reviewService;

import umc.spring.domain.Review;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;

public interface ReviewService {
    Review addReview(ReviewRequestDTO.AddReviewDTO request);
}
