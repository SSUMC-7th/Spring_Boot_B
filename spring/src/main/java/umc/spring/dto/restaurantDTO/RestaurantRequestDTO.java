package umc.spring.dto.restaurantDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
public class RestaurantRequestDTO {
    @Getter
    public static class AddRestaurantDTO {

        @NotNull(message = "가게 이름은 필수 입력값입니다.")
        private String name;

        private String category;

        private Float score;

        private String address;

        private String addressBig; //시

        private String addressMiddle;  //구

        private String addressSmall;  //동

        private String region;

    }
}

