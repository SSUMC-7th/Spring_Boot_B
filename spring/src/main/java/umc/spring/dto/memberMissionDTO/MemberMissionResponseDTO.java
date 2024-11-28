package umc.spring.dto.memberMissionDTO;

import lombok.*;
import umc.spring.dto.missionDTO.MissionResponseDTO;

import java.time.LocalDate;
import java.util.List;

@Data
public class MemberMissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionIdDTO {
        private Long memberMissionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionListDTO {
        List<MemberMissionResponseDTO.MemberMissionPreViewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreViewDTO {
        Integer missionPoint;
        LocalDate deadline;
        String content;
        String restaurantName;
    }
}
