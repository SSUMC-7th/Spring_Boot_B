package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface ReviewQueryService {
    Review createReview(Long memberId, Long storeId, String body, float score);

    Page<Review> getMyReviews(Long memberId, Integer page);
}
