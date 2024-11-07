package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

public interface ReviewQueryService {
    Review createReview(Long memberId, Long storeId, String body, float score);
}
