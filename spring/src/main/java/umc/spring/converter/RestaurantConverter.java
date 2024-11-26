package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.dto.restaurantDTO.RestaurantRequestDTO;
import umc.spring.dto.restaurantDTO.RestaurantResponseDTO;

public class RestaurantConverter {
    public static Restaurant toRestaurant(RestaurantRequestDTO.AddRestaurantDTO request, Region region) {
        return Restaurant.builder()
                .category(request.getCategory())
                .name(request.getName())
                .score(request.getScore())
                .address(request.getAddress())
                .region(region)
                .build();
    }

    public static RestaurantResponseDTO.RestaurantIdDTO toRestaurantIdDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.RestaurantIdDTO.builder()
                .restaurantId(restaurant.getId())
                .build();
    }
}
