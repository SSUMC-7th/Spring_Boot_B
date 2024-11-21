package umc.spring.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class createMissionDto {

        private Long storeId;

        private String missionSpec;

        private Integer reward;

        private LocalDateTime deadline;

        private Integer missionStatus;

    }
}
