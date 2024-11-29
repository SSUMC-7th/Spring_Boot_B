package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.dto.reviewDTO.ReviewResponseDTO;
import umc.spring.service.reviewService.ReviewService;


@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
/*
    @Operation(summary = "리뷰 등록", description = "레스토랑 아이디로 리뷰 등록 api입니다.")
    @PostMapping("/add")
    public ApiResponse<ReviewResponseDTO.ReviewIdDTO> addReview(@Valid @RequestBody ReviewRequestDTO.AddReviewDTO request) {
        Review review = reviewService.addReview(request);
        ReviewResponseDTO.ReviewIdDTO response = ReviewConverter.toReviewIdDTO(review);
        return ApiResponse.of(SuccessStatus.REVIEW_CREATE_OK, response);
    }

    @Operation(summary = "리뷰 가져오기", description = "레스토랑 아이디로 리뷰 가져오는 api입니다.")
    @PostMapping("/{restaurantId}")
    public ApiResponse<ReviewResponseDTO.ReviewIdDTO> addReview(@Valid @RequestBody ReviewRequestDTO.AddReviewDTO request) {
        Review review = reviewService.addReview(request);
        ReviewResponseDTO.ReviewIdDTO response = ReviewConverter.toReviewIdDTO(review);
        return ApiResponse.of(SuccessStatus.REVIEW_CREATE_OK, response);
    }

 */
}
