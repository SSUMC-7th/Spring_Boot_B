package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface ReviewQueryService {
    Review saveReview(Long memberId, Long storeId, String content, float rating);
    Page<Review> getStoreReviewList(Long StoreId, Integer page);
    Page<Review> getMemberReviewList(Long MemberId, Integer page);
}
