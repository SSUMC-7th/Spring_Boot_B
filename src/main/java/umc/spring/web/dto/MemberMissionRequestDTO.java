package umc.spring.web.dto;

import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class MissionChallengeRequestDTO {
        private Long missionId;

        private Long memberId;
    }
}
