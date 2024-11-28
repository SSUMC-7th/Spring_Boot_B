package umc.spring.dto.missionDTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class MissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionIdDTO {
        Long missionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RestaurantMissionListDTO {
        List<MissionResponseDTO.RestaurantMissionPreViewDTO> missionList;
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
    public static class RestaurantMissionPreViewDTO {
        Integer missionPoint;
        LocalDate deadline;
        String content;
    }
}
