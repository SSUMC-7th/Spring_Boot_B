package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missions) {
        return MissionResponseDTO.MissionListDTO.builder()
                .missions(missions.getContent().stream()
                        .map(MissionConverter::toMissionDTO)
                        .collect(Collectors.toList()))
                .listSize(missions.getNumberOfElements())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }

    public static MissionResponseDTO.MissionDTO toMissionDTO(Mission mission) {
        return MissionResponseDTO.MissionDTO.builder()
                .id(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .status(mission.getMissionStatus().name())
                .build();
    }
}
