package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

public interface ReviewQueryService {
    Review saveReview(Long memberId, Long storeId, String content, float rating);
}
