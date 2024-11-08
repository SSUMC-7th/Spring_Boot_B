package umc.spring.repository.ReviewRepository;

import umc.spring.domain.Review;

public interface ReviewRepositoryCustom {
    Review dynamicQueryCreateReview(Long memberId, Long storeId, String body, float score);
}
