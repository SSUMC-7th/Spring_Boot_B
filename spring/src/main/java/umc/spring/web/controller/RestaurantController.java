package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.dto.restaurantDTO.RestaurantRequestDTO;
import umc.spring.dto.restaurantDTO.RestaurantResponseDTO;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.dto.reviewDTO.ReviewResponseDTO;
import umc.spring.handler.annotation.CheckPage;
import umc.spring.handler.annotation.RestaurantExists;
import umc.spring.service.restaurantService.RestaurantService;
import umc.spring.service.reviewService.ReviewService;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Operation(summary = "특정 지역에 음식점 등록", description = "특정 지역에 음식점 등록 api입니다.")
    @PostMapping("/add")
    public ApiResponse<RestaurantResponseDTO.RestaurantIdDTO> addMission(@Valid @RequestBody RestaurantRequestDTO.AddRestaurantDTO request) {
        Restaurant restaurant = restaurantService.addRestaurant(request);
        RestaurantResponseDTO.RestaurantIdDTO response = RestaurantConverter.toRestaurantIdDTO(restaurant);
        return ApiResponse.of(SuccessStatus.RESTAURANT_CREATE_OK, response);
    }
}
