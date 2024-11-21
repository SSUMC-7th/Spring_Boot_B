package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDto toCreateMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }


    public static Mission toMission(MissionRequestDTO.createMissionDto request, Store store) {
        MissionStatus missionStatus = null;

        switch (request.getMissionStatus()) {
            case 1:
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case 2:
                missionStatus = MissionStatus.COMPLETE;
                break;
        }

        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline().toLocalDate())
                .missionStatus(missionStatus)
                .store(store)
                .build();
    }
}
