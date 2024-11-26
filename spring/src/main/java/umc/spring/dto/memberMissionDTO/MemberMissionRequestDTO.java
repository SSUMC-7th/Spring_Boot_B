package umc.spring.dto.memberMissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import umc.spring.handler.annotation.RestaurantExists;

import java.time.LocalDate;

@Data
public class MemberMissionRequestDTO {
    @Getter
    public static class AddMemberMissionDTO {

        @NotNull(message = "멤버 ID는 필수 입력값입니다.")
        private Long memberId;

        @NotNull(message = "미션 ID는 필수 입력값입니다.")
        private Long missionId;

    }
}
