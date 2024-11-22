package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

public interface ReviewService {
    Review joinReview(Long memberId, Long storeId, ReviewRequestDTO.JoinDTO request);
}
