package umc.spring.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class CreateReviewDto {
        private Long memberId;
        private Long storeId;
        private String body;
        private Float score;
    }
}