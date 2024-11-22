package umc.spring.service.ReviewService;

import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.CreateReviewResultDto addReview(ReviewRequestDTO.CreateReviewDto request);
}

