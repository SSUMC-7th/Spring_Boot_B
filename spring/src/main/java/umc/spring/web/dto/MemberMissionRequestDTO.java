package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.CheckProgressMemberMission;

public class MemberMissionRequestDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberMissionDto {
        @NotNull
        private Long memberId;

        @NotNull
        private Long missionId;
    }
}