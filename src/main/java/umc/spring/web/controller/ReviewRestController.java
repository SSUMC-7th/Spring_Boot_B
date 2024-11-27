package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    private final ReviewQueryService reviewQueryService;

    @PostMapping("/create")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(@RequestBody ReviewRequestDTO.CreateReviewDto request) {
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDto(review));
    }

    @GetMapping("/my-reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회", description = "사용자가 작성한 리뷰 목록을 조회합니다. 페이지는 1부터 시작합니다.")
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getMyReviewList(
            @RequestParam(name = "memberId") Long memberId,
            @RequestParam(name = "page") @CheckPage Integer page) {
        Page<Review> reviewList = reviewQueryService.getMyReviews(memberId,page - 1);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}