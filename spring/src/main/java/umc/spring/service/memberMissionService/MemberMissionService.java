package umc.spring.service.memberMissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMissionDTO.MemberMissionRequestDTO;

public interface MemberMissionService {
    MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDTO request);
}
