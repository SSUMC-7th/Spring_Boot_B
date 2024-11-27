package umc.spring.handler.resolver;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.handler.annotation.RestaurantExists;
import umc.spring.repository.restaurantRepository.RestaurantRepository;

@Component
public class RestaurantExistsValidator implements ConstraintValidator<RestaurantExists, Long> {

    private final RestaurantRepository restaurantRepository;

    public RestaurantExistsValidator(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public boolean isValid(Long restaurantId, ConstraintValidatorContext context) {
        if (restaurantId == null) {
            return false;
        }
        return restaurantRepository.existsById(restaurantId);
    }
}

