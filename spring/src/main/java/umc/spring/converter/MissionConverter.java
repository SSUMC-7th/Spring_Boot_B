package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.dto.missionDTO.MissionRequestDTO;
import umc.spring.dto.missionDTO.MissionResponseDTO;
import umc.spring.dto.reviewDTO.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.RestaurantMissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.RestaurantMissionPreViewDTO.builder()
                .missionPoint(mission.getMissionPoint())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .build();
    }
    public static MissionResponseDTO.RestaurantMissionListDTO restaurantMissionListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.RestaurantMissionPreViewDTO> restaurantMissionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.RestaurantMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(restaurantMissionPreViewDTOList.size())
                .missionList(restaurantMissionPreViewDTOList)
                .build();
    }
}
