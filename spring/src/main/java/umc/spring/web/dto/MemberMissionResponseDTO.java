package umc.spring.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "MemberMissionCreateResultDto")
    public static class CreateResultDto {
        private Long memberMissionId;
        private Long memberId;
        private Long missionId;
        private String status;
    }
}

