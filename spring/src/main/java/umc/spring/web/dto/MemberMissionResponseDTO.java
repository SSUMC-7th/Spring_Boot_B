package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberMissionResultDto {
        private Long memberMissionId;
        private Long memberId;
        private Long missionId;
        private String status;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateMissionCompleteResultDTO {
        private Long memberMissionId;
        private Long memberId;
        private Long missionId;
        private String status;
    }
}

