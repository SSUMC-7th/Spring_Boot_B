package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewServiceImpl;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @PostMapping("/{memberId}/{storeId}")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(
            @PathVariable("memberId") Long memberId,
            @PathVariable("storeId") @ExistStores Long storeId,
            @RequestBody @Valid ReviewRequestDTO.JoinDTO request) {

        Review newReview = reviewService.joinReview(memberId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(newReview));
    }
}
