package umc.spring.dto.reviewDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import umc.spring.handler.annotation.RestaurantExists;

@Data
public class ReviewRequestDTO {

    @Getter
    public static class AddReviewDTO {

        private Long memberId;

        private String title;
        @NotNull(message = "리뷰 내용은 필수 입력값입니다.")
        private String content;

        private float rate;
    }
}
