package umc.spring.service.reviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;

public interface ReviewService {
    Review addReview(ReviewRequestDTO.AddReviewDTO request, Long restaurantId);
    Page<Review> getReviewListByRestaurantId(Long restaurantId, Integer page);
    Page<Review> getReviewListByMemberId(Long memberId, Integer page);
}
