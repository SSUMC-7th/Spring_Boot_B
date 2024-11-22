package umc.spring.service.ReviewService;

import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.CreateResultDto addReview(ReviewRequestDTO.CreateDto request);
}

