package umc.spring.service.restaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.dto.restaurantDTO.RestaurantRequestDTO;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.restaurantRepository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Override
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request){
        Region region = regionRepository.findByName(request.getRegion())
                .orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));
        Restaurant restaurant = RestaurantConverter.toRestaurant(request, region);
        restaurantRepository.save(restaurant);
        return restaurant;
    }
}
