package umc.spring.service.restaurantService;

import umc.spring.domain.Restaurant;
import umc.spring.dto.restaurantDTO.RestaurantRequestDTO;

public interface RestaurantService {
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request);
}
