package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateMissionDto request, Store store) {
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .dueDate(request.getDueDate())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .id(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .dueDate(mission.getDueDate())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missions) {
        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .missions(missions.getContent().stream()
                        .map(MissionConverter::missionPreViewDTO)
                        .collect(Collectors.toList()))
                .listSize(missions.getNumberOfElements())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }

    public static MissionResponseDTO.CreateMissionResultDto toCreateResultDto(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .dueDate(mission.getDueDate())
                .createdAt(LocalDateTime.now().toString())
                .build();
    }
}

