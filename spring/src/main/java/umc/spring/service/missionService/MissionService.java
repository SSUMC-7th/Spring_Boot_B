package umc.spring.service.missionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.dto.missionDTO.MissionRequestDTO;

public interface MissionService {
    Mission addMission(MissionRequestDTO.AddMissionDTO request);
    Page<Mission> getMissionListByRestaurantId(Long restaurantId, Integer page);
}
