package umc.spring.service.missionService;

import umc.spring.domain.Mission;
import umc.spring.dto.missionDTO.MissionRequestDTO;
import umc.spring.dto.reviewDTO.ReviewRequestDTO;

public interface MissionService {
    Mission addMission(MissionRequestDTO.AddMissionDTO request);
}
