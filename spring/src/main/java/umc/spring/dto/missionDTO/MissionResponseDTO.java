package umc.spring.dto.missionDTO;

import lombok.*;

@Data
public class MissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionIdDTO {
        Long missionId;
    }
}
