package umc.spring.dto.memberMissionDTO;

import lombok.*;

@Data
public class MemberMissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionIdDTO {
        private Long memberMissionId;
    }
}
