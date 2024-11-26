package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.dto.missionDTO.MissionRequestDTO;
import umc.spring.dto.missionDTO.MissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.AddMissionDTO request, Restaurant restaurant) {
        return Mission.builder()
                .content(request.getContent())
                .missionPoint(request.getMissionPoint())
                .deadline(request.getDeadline())
                .restaurant(restaurant)
                .build();
    }

    public static MissionResponseDTO.MissionIdDTO toMissionIdDTO(Mission mission) {
        return MissionResponseDTO.MissionIdDTO.builder()
                .missionId(mission.getId())
                .build();
    }
}
