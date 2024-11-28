package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.dto.reviewDTO.ReviewResponseDTO;
import umc.spring.handler.annotation.CheckPage;
import umc.spring.handler.annotation.RestaurantExists;
import umc.spring.handler.resolver.CheckPageValidator;
import umc.spring.service.reviewService.ReviewService;


@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @Operation(summary = "리뷰 등록", description = "레스토랑 아이디로 리뷰 등록 api입니다.")
    @PostMapping("/add")
    public ApiResponse<ReviewResponseDTO.ReviewIdDTO> addReview(@Valid @RequestBody ReviewRequestDTO.AddReviewDTO request, @RestaurantExists @PathVariable(name = "restaurantId") Long restaurantId) {
        Review review = reviewService.addReview(request, restaurantId);
        ReviewResponseDTO.ReviewIdDTO response = ReviewConverter.toReviewIdDTO(review);
        return ApiResponse.of(SuccessStatus.REVIEW_CREATE_OK, response);
    }

    @Operation(summary = "특정 사용자의 리뷰 가져오기", description = "memberId로 리뷰 가져오는 api입니다.")
    @GetMapping("/members/{memberId}")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewListByMemberId(@RestaurantExists @PathVariable(name = "memberId") Long memberId,
                                                                                       @CheckPage @RequestParam(name = "page") Integer page) {
        ReviewResponseDTO.ReviewPreViewListDTO response = ReviewConverter.reviewPreViewListDTO(reviewService.getReviewListByMemberId(memberId, CheckPageValidator.adjustPage(page)));
        return ApiResponse.of(SuccessStatus.REVIEW_GET_OK, response);
    }
}
