package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionService {
    Mission joinMission(MissionRequestDTO.JoinDTO request, Long storeId);
}
