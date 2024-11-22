package umc.spring.service.MemberMisisonService;

import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMissionResponseDTO.MissionChallengeResponseDTO challengeMission(MemberMissionRequestDTO.MissionChallengeRequestDTO request);
}