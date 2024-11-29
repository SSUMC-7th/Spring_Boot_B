package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission makeMemberMissionInProgress(MemberMissionRequestDTO.CreateMemberMissionDto request);
}
