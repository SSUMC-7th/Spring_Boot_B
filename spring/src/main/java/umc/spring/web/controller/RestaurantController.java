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
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.dto.restaurantDTO.RestaurantRequestDTO;
import umc.spring.dto.restaurantDTO.RestaurantResponseDTO;
import umc.spring.service.restaurantService.RestaurantService;

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
