package umc.spring.dto.missionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import umc.spring.handler.annotation.RestaurantExists;

import java.time.LocalDate;

@Data
public class MissionRequestDTO {
    @Getter
    public static class AddMissionDTO {

        @NotNull(message = "가게 ID는 필수 입력값입니다.")
        @RestaurantExists
        private Long restaurantId;

        private float rate;

        private Integer missionPoint;

        private LocalDate deadline;

        private String content;

    }
}
